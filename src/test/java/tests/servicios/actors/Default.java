package tests.servicios.actors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.an.E;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import tests.ui.paths.Path;
import utils.DataExcel;
import utils.MetodosFeature;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import static io.restassured.RestAssured.given;

public class Default extends DataExcel {

   private final String baseURI = "https://poc.zytrust.com/ztgateway/oauth-server";
   private final String baseURIFlujo = "https://poc.zytrust.com/ztgateway/contrato-server/api";

   public RequestSpecification request;
   private Response response;
   public JSONObject jsonObject = new JSONObject();

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
       System.out.printf("\n");
       int responseCode = response.then().log().all().extract().statusCode();
       Assert.assertEquals(codigo,responseCode+"");

    }

    public void guardarToken(){
       token = response.then().extract().body().jsonPath().getString("access_token");
       registrarValor("access_token","Bearer " + token);

    }

    public void validarLoginDeUsuario(){

       RestAssured.config = RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());

        RestAssured.baseURI = baseURIFlujo;


        try {
           String jsonFile = "src/test/resources/jsons/Registrar_Error_#01_Data Invalida.json";
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

    public void validarYGuardarToken(){
        System.out.printf(response.toString());
    }

    public void getCerrarSesion() throws IOException {
       request = given().header("Content-Type","application/json").
               header("Authorization","Token "+ getCellValue("Hoja1",2,12)).contentType("application/json")
               .accept("application/json").body(jsonObject.toJSONString()).log().all();
    }

    public void validarBodyVacio(){
       String body = response.getBody().asString();
       Assert.assertEquals(body,"");
    }

    public void validarErrorEmailExiste(String mensaje){
       String emailError = response.then().extract().body().jsonPath().getString("email").replace("[","").replace("]","").trim();
       Assert.assertEquals(mensaje,emailError);
    }

    public void validarErrorEnterpriseIDExiste(String mensaje){
       String enterpriseIDError = response.then().extract().body().jsonPath().getString("enterpriseID").replace("[","").replace("]","").trim();
       Assert.assertEquals(mensaje,enterpriseIDError);
    }

    public void postRegistroConErrorEmail() {
        jsonObject.put("email",retornarValor("email", MetodosFeature.getScenario()));
        jsonObject.put("password",retornarValor("password", MetodosFeature.getScenario()));
        jsonObject.put("passwordConfirm",retornarValor("passwordConfirm", MetodosFeature.getScenario()));
        jsonObject.put("enterpriseName",retornarValor("enterpriseName", MetodosFeature.getScenario()));
        jsonObject.put("enterpriseLocation",retornarValor("enterpriseLocation", MetodosFeature.getScenario()));
        jsonObject.put("enterpriseAddress",retornarValor("enterpriseAddress", MetodosFeature.getScenario()));
        jsonObject.put("name",retornarValor("name", MetodosFeature.getScenario()));
        jsonObject.put("phone",retornarValor("phone", MetodosFeature.getScenario()));
        jsonObject.put("position",retornarValor("position", MetodosFeature.getScenario()));
        jsonObject.put("enterpriseID",retornarValor("enterpriseID", MetodosFeature.getScenario()));

        RestAssured.baseURI = baseURI;

        request = given().header("Content-Type","application/json").contentType("application/json")
                .accept("application/json").body(jsonObject.toJSONString()).log().all();
    }

    public void postRegistroConErrorEnterpriseID() {
        jsonObject.put("email",retornarValor("email", MetodosFeature.getScenario()));
        jsonObject.put("password",retornarValor("password", MetodosFeature.getScenario()));
        jsonObject.put("passwordConfirm",retornarValor("passwordConfirm", MetodosFeature.getScenario()));
        jsonObject.put("enterpriseName",retornarValor("enterpriseName", MetodosFeature.getScenario()));
        jsonObject.put("enterpriseLocation",retornarValor("enterpriseLocation", MetodosFeature.getScenario()));
        jsonObject.put("enterpriseAddress",retornarValor("enterpriseAddress", MetodosFeature.getScenario()));
        jsonObject.put("name",retornarValor("name", MetodosFeature.getScenario()));
        jsonObject.put("phone",retornarValor("phone", MetodosFeature.getScenario()));
        jsonObject.put("position",retornarValor("position", MetodosFeature.getScenario()));
        jsonObject.put("enterpriseID",retornarValor("enterpriseID", MetodosFeature.getScenario()));

        RestAssured.baseURI = baseURI;

        request = given().header("Content-Type","application/json").contentType("application/json")
                .accept("application/json").body(jsonObject.toJSONString()).log().all();
    }
}
