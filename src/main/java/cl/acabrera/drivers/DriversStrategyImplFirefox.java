package cl.acabrera.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriversStrategyImplFirefox implements DriversStrategy {
    @Override
    public WebDriver setStrategy() {
        //Seteando ubicacion Driver
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        //Definiendo opciones
        FirefoxOptions options = new FirefoxOptions();
        //anulando funcionalidad de sandbox para prevenir errores
        options.addArguments("--no-sandbox");
        return new FirefoxDriver(options);



    }
}
