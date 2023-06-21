package cl.acabrera.drivers;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static DriverSingleton instance= null;
    private static WebDriver driver;

    //constructor
    private DriverSingleton(String browserName){
        instantiate(browserName);
    }
    //instanciando
    public WebDriver instantiate(String browserName){
        DriversStrategy driver = DriverStrategySelector.chooseStrategy(browserName);
        this.driver = driver.setStrategy();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        return this.driver;
    }

    //retornar instancia ya que es privado
    //es un constructor privado para generar una instancia única o sigle
    public static DriverSingleton getInstance(String browserName){
        if (instance==null){
            instance = new DriverSingleton(browserName);
        }
        return instance;
    }
    //cerrando la conexion
    public static void closeDriver(){
        instance = null;
        driver.close();
        driver.quit();
    }
    public static WebDriver getDriver() {
        return driver;
    }


}
