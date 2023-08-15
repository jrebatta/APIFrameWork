package tests.ui.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tests.ui.page.Page;

import java.awt.*;

public class Steps {

    Page page = new Page();

    @Given("Ingresar a la web de REDLO")
    public void ingresarALaWebDeRedlo() {
        page.ingresarALaWeb();
    }

    @When("se ingresan los datos de registro")
    public void seIngresanLosDatosDeRegistro() throws InterruptedException {
        page.ingresarDatos();
    }

    @Then("se valida la creacion del usuario en el email")
    public void seValidaLaCreacionDelUsuario() throws InterruptedException {
        page.validarRegistroCorrecto();
    }

    @And("se ingresan los datos de inicio de sesion")
    public void seIngresanLosDatosDeInicioDeSesion() throws InterruptedException {
        page.ingresarDatosInicioSesion();
    }

    @Then("se valida el inicio de sesion")
    public void seValidaElInicioDeSesion() throws InterruptedException {
        page.validarInicioSesion();
    }

    @Then("se cierra sesion")
    public void seCierraSesion() throws InterruptedException {
        page.validarCierreDeSesion();
    }

    @Then("se valida el error de email existente {string}")
    public void seValidaElErrorDeEmailExistente(String email) throws InterruptedException {
        page.validarEmailExistente(email);
    }

    @Then("se valida el error de enterpriseID existente {string}")
    public void seValidaElErrorDeEnterpriseIDExistente(String enterpriseID) throws InterruptedException {
        page.validarEnterpriseIDExistente(enterpriseID);

    }

    @When("se ingresan los datos de registro con error email")
    public void seIngresanLosDatosDeRegistroConErrorEmail() throws InterruptedException {
        page.ingresarDatosConErrorEmail();
    }

    @When("se ingresan los datos de registro con error enterpriseID")
    public void seIngresanLosDatosDeRegistroConErrorEnterpriseID() throws InterruptedException {
        page.ingresarDatosConErrorentErpriseID();
    }
}
