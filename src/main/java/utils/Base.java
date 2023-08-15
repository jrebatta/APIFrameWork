package utils;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class Base {

    public WebDriver driver;

    public Alert alert;

    public Base(WebDriver driver){
        this.driver = driver;
    }

    public Base() {

    }

    public WebDriver chromeDriverConnection() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public WebElement findElement(By locator){

        return driver.findElement(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }
    public void login(String user, String pass){
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void visit(String url){
        driver.get(url);
    }

    public void isDisplayed(By locator){
        driver.findElement(locator).isDisplayed();
    }

    public void maximize(){
        driver.manage().window().maximize();
    }

    public void choose(String number, By locator) {
        Select selectList = new Select(findElement(locator));
        selectList.selectByValue(number);
    }

    public void chooseByText(String text, By locator) {
        Select selectList = new Select(findElement(locator));
        selectList.selectByVisibleText(text);
    }

    public static String getValueFromDataTable(DataTable dataTable, String title) {
        List<Map<String, String>> list = dataTable.asMaps();
        return (String)((Map)list.get(0)).get(title);
    }

    public void implicitWait(int number) throws InterruptedException {
        Thread.sleep(number);
    }

    public void alertAcept() {
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public String alertgetText() {
        alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void cambiarPestana(int valor){
        driver.switchTo().window(driver.getWindowHandles().toArray()[valor].toString());
    }

    public void abrirNuevaPestana(String valor){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        String nueva = "window.open('"+valor+"')";
        javascriptExecutor.executeScript(nueva);

    }

    public void pegarDesdeElPortaPapeles() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public static long generateRandomNumber() {
        Random random = new Random();
        int firstDigit = random.nextInt(9) + 1; // asegura que el primer dígito no sea cero
        StringBuilder sb = new StringBuilder();
        sb.append(firstDigit);
        for (int i = 1; i < 11; i++) {
            sb.append(random.nextInt(10));
        }
        return Long.parseLong(sb.toString());
    }

    public static String generateRandomText() {

        final String CHARACTERS = "abcdefghijk";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            char c = CHARACTERS.charAt(random.nextInt(CHARACTERS.length()));
            sb.append(c);
        }

        return sb.toString();
    }


}
