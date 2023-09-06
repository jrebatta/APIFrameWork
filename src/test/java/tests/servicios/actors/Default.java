package tests.servicios.actors;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.DataExcel;
import utils.MetodosFeature;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.RestAssured.given;

public class Default extends DataExcel {

   private final String baseURI = "https://poc.zytrust.com/ztgateway/oauth-server";
   private final String baseURIFlujo = "https://poc.zytrust.com/ztgateway/contrato-server/api";
   public RequestSpecification request;
   private Response response;
   public String token;


   public void postRegistro(){
       RestAssured.config = RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
       RestAssured.baseURI = baseURI;
       request = given().header("Authorization", retornarValor("authorization", MetodosFeature.getScenario()))
              .formParam("username", retornarValor("username",MetodosFeature.getScenario()))
              .formParam("password", retornarValor("password",MetodosFeature.getScenario()))
              .formParam("grant_type", retornarValor("grant_type",MetodosFeature.getScenario()))
              .contentType(ContentType.URLENC).log().all();
    }

    public void validarCodigo(String codigo){
       response = request.when().post(retornarValor("URL", MetodosFeature.getScenario()));
       System.out.printf(retornarValor("URL", MetodosFeature.getScenario()));

       int responseCode = response.then().log().all().extract().statusCode();
       Assert.assertEquals(codigo,responseCode+"");
    }

    public void guardarToken(){
       token = response.then().extract().body().jsonPath().getString("access_token");
       registrarValor("access_token","Bearer " + token);
    }

    public void validarLoginDeUsuario(String json){
       RestAssured.config = RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
       RestAssured.baseURI = baseURIFlujo;
        try {
           String jsonFile = "src/test/resources/jsons/"+json+".json";
           String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFile)));
           request = given().header("Content-Type","application/json")
                   .header("Authorization",getCellValue("Hoja1",1,6))
                   .contentType("application/json")
                   .body(jsonContent).log().all();
       }
        catch (Exception e){
           System.out.printf(e.getMessage());
       }
    }

    public void validarYGuardarToken(String codigo){
       String cod = response.then().extract().body().jsonPath().getString("codigo");
       Assert.assertEquals(cod,codigo);
    }

}
