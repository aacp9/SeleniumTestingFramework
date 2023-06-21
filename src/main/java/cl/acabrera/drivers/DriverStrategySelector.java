package cl.acabrera.drivers;

public class DriverStrategySelector {
    public static DriversStrategy chooseStrategy (String browserName){
        switch (browserName){
            case "Chrome":
                return new DriversStrategyImplChrome();
            case "Firefox":
                return new DriversStrategyImplFirefox();
            default:
                return null;
        }
    }
}
