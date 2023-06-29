package au.com.ncs.tests;

import au.com.ncs.models.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matcher.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTests {
    private WebDriver driver;
    private WebDriverWait wait;

    private String url = "https://d18u5zoaatmpxx.cloudfront.net/#/";

    @BeforeEach
    public void setUp() {
        //Init driver and maximize it.
        driver = getWebDriver();
        driver.manage().window().maximize();
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    public void headerPlaygroundTest() {

        driver.findElement(By.id("forename")).sendKeys("Test123");
        driver.findElement(By.id("submit")).click();

        String header = driver.findElement(By.cssSelector("h1.mb-3")).getText();

        System.out.println("Located element's text : " + header);
        Assertions.assertEquals("Web Playground", header);

    }

    @Test
    public void clickDownTest() {
        By buttonBy = By.cssSelector("a.anibtn");
        System.out.println("Located element's text : " + driver.findElement(buttonBy).getText());
        driver.findElement(buttonBy).click();
        wait.until(
                ExpectedConditions.textToBe(buttonBy, "CLICK ME UP!"));
        Assertions.assertEquals("CLICK ME UP!",
                                driver.findElement(buttonBy).getText());
    }

    @Test
    public void clickUpTest() {
        By buttonBy = By.cssSelector("a.anibtn");
        System.out.println("Located element's text : " + driver.findElement(buttonBy).getText());
        driver.findElement(buttonBy).click();
        wait.until(
                ExpectedConditions.textToBe(buttonBy, "CLICK ME UP!"));

        driver.findElement(buttonBy).click();
        wait.until(
                ExpectedConditions.textToBe(buttonBy, "CLICK ME DOWN!"));

        Assertions.assertEquals("CLICK ME DOWN!",
                driver.findElement(buttonBy).getText());
    }

    @Test
    public void fillUpFormTest() {
        new Toolbar(driver).clickForms();
        Form form = new Form(driver);

        form.enterName("Test123");
        form.enterEmail("Test123@gmail.com");
        form.selectState("WA");
        form.clickAgree();
        form.submit();

        By welcomeBy = By.cssSelector("div.snackbar");
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(welcomeBy));

        Assertions.assertEquals("Thanks for your feedback Test123",
                driver.findElement(welcomeBy).getText());
    }

    @Test
    public void explorePlanetEarthTest() {
        new Toolbar(driver).clickPlanets();
        new PlanetPage(driver).getPlanet("earth").clickExplore();
        Assertions.assertEquals("Exploring Earth", new PlanetPage(driver).getPopUpMsg());
    }


    @AfterEach
    public void cleanUp() {
        driver.quit();
    }

    private static WebDriver getWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
}
