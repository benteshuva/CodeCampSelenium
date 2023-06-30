package au.com.ncs.models;

import au.com.ncs.strategies.MatchStrategyInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PlanetPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public PlanetPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPopUpMsg() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("popup-message")));
        return driver.findElement(By.className("popup-message")).getText();
    }

    public Planets getPlanet(Predicate<Planets> strategy) {
        for (Planets planet : getAllPlanets()) {
            if (strategy.test(planet)) {
                return planet;
            }
        }
        throw new NotFoundException("planet not found");
    }

    public List<Planets> getAllPlanets() {
        List<Planets> allPlanets = new ArrayList<>();
        for (WebElement planetElement: driver.findElements(By.className("planet"))) {
            allPlanets.add(new Planets(planetElement));
        }
        return allPlanets;
    }

}
