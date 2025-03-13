package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import utils.DriverFactory;

public class Hooks {
    public static WebDriver webDriver;
    @BeforeClass
    public void setup() {
        String browser = System.getProperty("browser", "chrome");  // Varsayılan olarak chrome
        DriverFactory.getDriver(browser);
    }
    @Before
    public void setUp(Scenario scenario) {
        String browser = System.getProperty("browser", "chrome");  // Default to Chrome

        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
        }

        webDriver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    public static WebDriver getDriver() {
        return webDriver;
    }
}

