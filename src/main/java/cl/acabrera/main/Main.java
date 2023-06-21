package cl.acabrera.main;

import cl.acabrera.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Selenium, Hellow Singleton!");
        //creando el singleton
        //acá asignamos el navegador a utilzar, 'Chrome' o 'Firefox'
        DriverSingleton driverSingleton = DriverSingleton.getInstance("Firefox");
        WebDriver driver = driverSingleton.getDriver();

        driver.get("https://www.wikipedia.org/");
        //escribir texto
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        String busqueda = "perro";
        searchBox.sendKeys(busqueda); //permite enviar texto a un input

        //click search button
        WebElement searchButtom = driver.findElement(By.cssSelector("#search-form > fieldset > button"));
        searchButtom.click();
        driverSingleton.closeDriver();


    }
}