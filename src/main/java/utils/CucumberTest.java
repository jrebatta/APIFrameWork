package utils;

import cucumber.api.Scenario;

public class CucumberTest {

    public static String codigoCASO;

    public static void starTest(Scenario scenario){
        String valor = scenario.getName();
        String[] codigo = valor.split(":");
        codigoCASO = codigo[0];
        String codigoCASO = scenario.getName().replace(":","_");
        MetodosFeature.addScenario(codigoCASO);
    }
}
