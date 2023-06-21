package cl.acabrera.main;

import cl.acabrera.drivers.DriverSingleton;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class TestBrowser {
    //se deja la variable de forma estática
    static  WebDriver driver;

    @BeforeAll
    public void initializeDriver(String browseName){
        //acá asignamos el navegador a utilzar, 'Chrome' o 'Firefox'
        DriverSingleton driverSingleton = DriverSingleton.getInstance(browseName);
        driver = driverSingleton.getDriver();


    }
    //zona de pruebas
    @Test
    public void testWikipediaSearch(){
        System.out.println("Zona de pruebas Hello Selenium, Hellow Singleton!");

        //obtiene una url
        driver.get("https://www.wikipedia.org/");

        //Buscar un texto
        WebElement searchBox= driver.findElement(By.id("searchInput"));
        String busqueda = "perros";
        searchBox.sendKeys(busqueda);

        //Dar Click al botón
        WebElement buttonSeach = driver.findElement(By.cssSelector("#search-form > fieldset > button"));
        buttonSeach.click();

        //validar si funcionó
        WebElement titleSearchedPage = driver.findElement(By.cssSelector("#firstHeading > span"));
        assertEquals(titleSearchedPage.getText(),"Canis familiaris","Enhorabuena!! encontramos perros: "+ titleSearchedPage.getText());
        //validando la url
        assertEquals(driver.getCurrentUrl(),"https://es.wikipedia.org/wiki/Canis_familiaris");



    }


    //después de que termine el proceso se cierra y sale de conexión.
    @AfterAll
    public void closeDriverBrowser(){
        driver.close();
        driver.quit();
    }
}