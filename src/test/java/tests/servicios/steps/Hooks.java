package tests.servicios.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import utils.CucumberTest;

public class Hooks {

    @Before
    public void beforeHook(Scenario scenario){
        CucumberTest.starTest(scenario);
    }

}
