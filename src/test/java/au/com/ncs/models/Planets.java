package au.com.ncs.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Planets {
    private WebDriver driver;
    private WebDriverWait wait;

    public Planets(WebDriver driver) {
        this.driver = driver;
    }
}
