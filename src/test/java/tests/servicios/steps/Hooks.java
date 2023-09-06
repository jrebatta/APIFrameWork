package tests.servicios.steps;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import utils.CucumberTest;


public class Hooks {

    @Before
    public void beforeHook(Scenario scenario){
        CucumberTest.starTest(scenario);
    }

}
