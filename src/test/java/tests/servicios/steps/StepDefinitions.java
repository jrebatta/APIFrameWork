package tests.servicios.steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tests.servicios.actors.Default;

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

    @Given("Obtener llamada al servicio de login con sus datos {string}")
    public void obtenerLlamadaAlServicioDeLoginConSusDatos(String json) {
        aDefault.validarLoginDeUsuario(json);
    }

    @Then("se valida que exista el token de sesion y se guarda {string}")
    public void seValidaQueExistaElTokenDeSesionYSeGuarda(String codigo) {
        aDefault.validarYGuardarToken(codigo);
    }
}

