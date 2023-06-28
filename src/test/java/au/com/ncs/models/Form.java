package au.com.ncs.models;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Form {
    private WebDriver driver;
    private WebDriverWait wait;

    public Form(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        driver.findElement(By.id("name")).sendKeys(name);
    }

    public void enterEmail(String mail) {
        driver.findElement(By.id("email")).sendKeys(mail);
    }

    public void selectState(String stateOption) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.cssSelector(".v-select__selections")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[role=option]")));
        List<WebElement> states = driver.findElements(By.cssSelector("div[role=option]"));
        System.out.println(states);
        for (WebElement state : states) {
            System.out.println(states);
            if (state.getText().equalsIgnoreCase(stateOption)) {
                state.click();
                return;
            }
//            throw new Exception("No such state was found in the list");
        }
        throw new NotFoundException("Could not find the state: "+stateOption);
    }

    public void clickAgree() {
        driver.findElement(By.cssSelector(".v-input--selection-controls__ripple")).click();
    }

    public void submit() {
        driver.findElement(By.cssSelector(".v-btn--is-elevated")).click();
    }
}
