package au.com.ncs.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Toolbar {
    private WebDriver driver;

    public Toolbar(WebDriver driver) {
        this.driver = driver;
    }

    public void clickForms() {
        driver.findElement(By.cssSelector("a[aria-label=forms]")).click();
    }
    public void clickPlanets() {
        driver.findElement(By.cssSelector("a[aria-label=planets]")).click();
    }
}
