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

    public long getDistance() {
        String distanceDirty = planetElement.findElement(By.className("distance")).getText();
        System.out.println(distanceDirty);
        String distanceClean = distanceDirty.replaceAll("[^0-9]+" , "");
        System.out.println("Distance after filter : "+ distanceClean);
        return Long.parseLong(distanceClean);
    }
}
