package au.com.ncs.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Planets {
    private final WebElement planetElement;

    public Planets(WebElement planetElement) {
        this.planetElement = planetElement;
    }

    public String getName() {
        return planetElement.findElement(By.className("name")).getText();
    }

    public void clickExplore() {
        planetElement.findElement(By.tagName("button")).click();
    }
}
