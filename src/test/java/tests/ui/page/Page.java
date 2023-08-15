package tests.ui.page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import tests.ui.paths.Path;
import utils.Base;
import utils.DataExcel;
import utils.MetodosFeature;

public class Page extends Base {

    DataExcel dataExcel = new DataExcel();

    Path path = new Path();

    public Page(WebDriver driver){
        super(driver);
    }

    public Page(){
        super();
    }

    public void ingresarALaWeb(){
        new Page(driver);
        chromeDriverConnection();
        visit(path.url);
        maximize();
    }

    public void ingresarDatos() throws InterruptedException {
        click(path.btnUnirse);
        type(dataExcel.retornarValor("enterpriseName",MetodosFeature.getScenario()),path.inputRazonSocial);
        type(String.valueOf(generateRandomNumber()),path.inputRUC);
        choose("PE-14",path.inputDepartament);
        implicitWait(2000);
        choose("PE-14-01",path.inputProvince);
        implicitWait(2000);
        choose("PE-14-01-41",path.inputDistrito);
        type(dataExcel.retornarValor("enterpriseAddress",MetodosFeature.getScenario()),path.inputDirección);
        type(+generateRandomNumber()+"@test"+".com",path.inputEmail);
        type(dataExcel.retornarValor("phone",MetodosFeature.getScenario()),path.inputTelefono);
        type(dataExcel.retornarValor("name",MetodosFeature.getScenario()),path.inputNombres);
        type(dataExcel.retornarValor("position",MetodosFeature.getScenario()),path.inputCargo);
        type(dataExcel.retornarValor("password",MetodosFeature.getScenario()),path.inputContraseña);
        type(dataExcel.retornarValor("passwordConfirm",MetodosFeature.getScenario()),path.inputConfirmContraseña);
        click(path.boxTerminos);
        click(path.btnUnirseAhora);
    }

    public void validarRegistroCorrecto() throws InterruptedException {
        implicitWait(2000);
        String bienvenido = getText(path.textBienvenido);
        Assert.assertEquals("Bienvenido a Redlo!",bienvenido);
        click(path.btnOk);
        driver.quit();
    }

    public void ingresarDatosInicioSesion() throws InterruptedException {
        implicitWait(1000);
        click(path.btnLogeo);
        type(dataExcel.retornarValor("email",MetodosFeature.getScenario()),path.inputUsuario);
        type(dataExcel.retornarValor("password",MetodosFeature.getScenario()),path.inputContraseña);
        click(path.btnLogin);
    }

    public void validarInicioSesion() throws InterruptedException {
        implicitWait(1000);
        String validar = getText(path.btnNoticias);
        Assert.assertEquals(validar,"Noticias");

    }

    public void validarCierreDeSesion() throws InterruptedException {
        implicitWait(1000);
        click(path.btnConfig);
        implicitWait(1000);
        click(path.btnCerrarSesion);
        String validar = getText(path.btnUnirse);
        Assert.assertEquals(validar,"Unirse");
        driver.quit();
    }

    public void validarEmailExistente(String error) throws InterruptedException {
        implicitWait(2000);
        String validar = getText(path.textEmailError);
        String[] parts = validar.split(":");
        String part1 = parts[2];
        System.out.println(part1);
        String [] parts1 = part1.split("\n");
        String textoAValidar = parts1[0];
        Assert.assertEquals(textoAValidar.trim(),error.trim());
        driver.quit();
    }

    public void validarEnterpriseIDExistente(String error) throws InterruptedException {
        implicitWait(1000);
        String validar = getText(path.textenterpriseIDError);
        String[] parts = validar.split(":");
        String part1 = parts[2];
        System.out.println(part1);
        String [] parts1 = part1.split("\n");
        String textoAValidar = parts1[0];
        Assert.assertEquals(textoAValidar.trim(),error.trim());
        driver.quit();
    }

    public void ingresarDatosConErrorEmail() throws InterruptedException {
        click(path.btnUnirse);
        type(dataExcel.retornarValor("enterpriseName",MetodosFeature.getScenario()),path.inputRazonSocial);
        type(dataExcel.retornarValor("enterpriseID",MetodosFeature.getScenario()),path.inputRUC);
        choose("PE-14",path.inputDepartament);
        implicitWait(2000);
        choose("PE-14-01",path.inputProvince);
        implicitWait(2000);
        choose("PE-14-01-41",path.inputDistrito);
        type(dataExcel.retornarValor("enterpriseAddress",MetodosFeature.getScenario()),path.inputDirección);
        type(dataExcel.retornarValor("email",MetodosFeature.getScenario()),path.inputEmail);
        type(dataExcel.retornarValor("phone",MetodosFeature.getScenario()),path.inputTelefono);
        type(dataExcel.retornarValor("name",MetodosFeature.getScenario()),path.inputNombres);
        type(dataExcel.retornarValor("position",MetodosFeature.getScenario()),path.inputCargo);
        type(dataExcel.retornarValor("password",MetodosFeature.getScenario()),path.inputContraseña);
        type(dataExcel.retornarValor("passwordConfirm",MetodosFeature.getScenario()),path.inputConfirmContraseña);
        click(path.boxTerminos);
        click(path.btnUnirseAhora);

    }

    public void ingresarDatosConErrorentErpriseID() throws InterruptedException {
        click(path.btnUnirse);
        type(dataExcel.retornarValor("enterpriseName",MetodosFeature.getScenario()),path.inputRazonSocial);
        type(dataExcel.retornarValor("enterpriseID",MetodosFeature.getScenario()),path.inputRUC);
        choose("PE-14",path.inputDepartament);
        implicitWait(2000);
        choose("PE-14-01",path.inputProvince);
        implicitWait(2000);
        choose("PE-14-01-41",path.inputDistrito);
        type(dataExcel.retornarValor("enterpriseAddress",MetodosFeature.getScenario()),path.inputDirección);
        type(dataExcel.retornarValor("email",MetodosFeature.getScenario()),path.inputEmail);
        type(dataExcel.retornarValor("phone",MetodosFeature.getScenario()),path.inputTelefono);
        type(dataExcel.retornarValor("name",MetodosFeature.getScenario()),path.inputNombres);
        type(dataExcel.retornarValor("position",MetodosFeature.getScenario()),path.inputCargo);
        type(dataExcel.retornarValor("password",MetodosFeature.getScenario()),path.inputContraseña);
        type(dataExcel.retornarValor("passwordConfirm",MetodosFeature.getScenario()),path.inputConfirmContraseña);
        click(path.boxTerminos);
        click(path.btnUnirseAhora);

    }









}
