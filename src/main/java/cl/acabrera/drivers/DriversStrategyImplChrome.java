package cl.acabrera.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriversStrategyImplChrome implements DriversStrategy {
    @Override
    public WebDriver setStrategy() {
        //Seteando ubicacion Driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //Definiendo opciones
        ChromeOptions options = new ChromeOptions();
        //anulando funcionalida para prevenir errores
        options.setExperimentalOption("useAutomationExtension", false);
        //anulando funcionalidad de sandbox para prevenir errores
        options.addArguments("--no-sandbox");
        return new ChromeDriver(options);
    }
}
