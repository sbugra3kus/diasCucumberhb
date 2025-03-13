package base;


import enums.BrowserType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import utils.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    private static WebDriver webDriver;
    private final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    Scenario scenario;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }
    @BeforeClass
    public void setup() {
        String browser = System.getProperty("browser", "chrome");  // Varsayılan olarak chrome
        DriverFactory.getDriver(browser);
    }
    @Before
    public void setUp() {
        String browser = System.getProperty("BROWSER");
        if (browser == null || browser.isEmpty()) {
            System.out.println("Browser değeri belirtilmedi, varsayılan olarak CHROME kullanılıyor.");
            browser = "CHROME";  // Varsayılan değer
        }

        BrowserType browserType = BrowserType.valueOf(browser.toUpperCase());
        logger.info("---Test is starting---");
        switch (browserType) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                //chromeOptions.setBrowserVersion("115");
                chromeOptions.addArguments("--disable-popup-blocking");
                setWebDriver(new ChromeDriver(chromeOptions));
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                setWebDriver(new EdgeDriver(edgeOptions));
                break;
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                //options.setBrowserVersion("116");
                setWebDriver(new FirefoxDriver(firefoxOptions));
                break;
            case SAFARI:
                SafariOptions safariOptions = new SafariOptions();
                //options.setBrowserVersion("16.1");
                setWebDriver(new SafariDriver(safariOptions));
                break;
        }
        logger.info(browser + " driver is running");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void tearDown() {
        takeScreenshot(scenario.getName());
        if (webDriver != null) {
            webDriver.quit();
            logger.info("---Test finished---");
        }
    }
    public void takeScreenshot(String scenarioName) {
        try {
            File screenshotFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            File screenshotsFolder = new File("screenshots");
            if (!screenshotsFolder.exists()) {
                screenshotsFolder.mkdir();
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            String timestamp = LocalDateTime.now().format(formatter);
            String screenshotFileName = "screenshots/" + scenarioName + "_" + timestamp + ".png";
            FileHandler.copy(screenshotFile, new File(screenshotFileName));
            logger.info("Screenshot taken and saved as: " + screenshotFileName);
        } catch (IOException e) {
            logger.error("Failed to take screenshot: " + e.getMessage());
        }
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}