package tests.ui.paths;

import org.openqa.selenium.By;

public class Path {

    public static String url = "https://dev.redlo.com.pe/";
    public By btnUnirse = By.xpath("//button[.='Unirse']");
    public By inputRazonSocial = By.xpath("//input[@name='enterpriseName']");
    public By inputRUC = By.xpath("//input[@name='enterpriseID']");
    public By inputDepartament = By.xpath("//select[@name='departament']");
    public By inputProvince = By.xpath("//select[@name='province']");
    public By inputDistrito= By.xpath("//select[@name='enterpriseLocation']");
    public By inputDirección= By.xpath("//input[@name='enterpriseAddress']");
    public By inputEmail= By.xpath("//input[@name='email']");
    public By inputTelefono= By.xpath("//input[@name='phone']");
    public By inputNombres= By.xpath("//input[@name='name']");
    public By inputCargo= By.xpath("//input[@name='position']");
    public By inputContraseña= By.xpath("//input[@name='password']");
    public By inputConfirmContraseña= By.xpath("//input[@name='passwordConfirm']");
    public By boxTerminos= By.xpath("//input[@name='termsChecked']");
    public By btnUnirseAhora = By.xpath("//button[.='Unirme ahora']");
    public By textBienvenido = By.xpath("//h2[.='Bienvenido a Redlo!']");
    public By btnOk = By.xpath("//button[.='OK']");

    public By inputUsuario= By.xpath("//input[@name='username']");
    public By btnLogeo = By.xpath("//button[@class='btn-form btn btn btn-primary']");
    public By btnLogin = By.xpath("//button[.='Iniciar Sesion']");
    public By btnNoticias = By.xpath("//div[.='Noticias']");
    public By btnConfig = By.xpath("/html/body/div/div/div/div[1]/div/div/div/div[3]/div[4]/button");

    public By btnCerrarSesion = By.xpath("//span[.='Cerrar sesión']");

    public By textEmailError = By.xpath("//div[@class='text-center mt-4  modal-body']");
    public By textenterpriseIDError = By.xpath("//div[@class='text-center mt-4  modal-body']");



}
