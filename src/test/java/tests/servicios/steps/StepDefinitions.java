package tests.servicios.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tests.servicios.actors.Default;
import java.io.IOException;


public class StepDefinitions {
    Default aDefault = new Default();

    @Given("Obtener llamada al servicio de registro con sus datos")
    public void obtenerLlamadaAlServicioDeRegistroConSusDatos() {
        aDefault.postRegistro();
    }

    @When("se valida el codigo de respuesta {string}")
    public void seValidaElCodigoDeRespuesta(String codigo) {
        aDefault.validarCodigo(codigo);
    }

    @Then("guardamos el token obtenido")
    public void guardamosElTokenObtenido() {
        aDefault.guardarToken();
    }

    @Given("Obtener llamada al servicio de login con sus datos")
    public void obtenerLlamadaAlServicioDeLoginConSusDatos() {
        aDefault.validarLoginDeUsuario();
    }

    @Then("se valida que exista el token de sesion y se guarda")
    public void seValidaQueExistaElTokenDeSesionYSeGuarda() {
        aDefault.validarYGuardarToken();
    }

    @Given("Obtener llamada al servicio de cerrar sesion")
    public void obtenerLlamadaAlServicioDeCerrarSesion() throws IOException {
        aDefault.getCerrarSesion();
    }

    @Then("se valida el body vacio")
    public void seValidaElBodyVacio() {
        aDefault.validarBodyVacio();
    }

    @Then("se valida la respuesta del servicio error email {string}")
    public void seValidaLaRespuestaDelServicioErrorEmail(String mensaje) {
        aDefault.validarErrorEmailExiste(mensaje);
    }

    @Then("se valida la respuesta del servicio error enterpriseID {string}")
    public void seValidaLaRespuestaDelServicioErrorEnterpriseID(String mensaje) {
        aDefault.validarErrorEnterpriseIDExiste(mensaje);
    }

    @Given("Obtener llamada al servicio de registro con sus datos con error email")
    public void obtenerLlamadaAlServicioDeRegistroConSusDatosConErrorEmail() {
        aDefault.postRegistroConErrorEmail();

    }

    @Given("Obtener llamada al servicio de registro con sus datos con error enterpriseID")
    public void obtenerLlamadaAlServicioDeRegistroConSusDatosConErrorEnterpriseID() {
        aDefault.postRegistroConErrorEnterpriseID();
    }
}
