package base;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static constants.HepsiburadaSearchConstants.*;

public class BasePage {
    private WebDriver webDriver = BaseTest.getWebDriver();
    WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    String productPrice;
    public void navigateUrl(String url){
        webDriver.get(url);
    }
    public WebElement findElement(By by){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        return webDriver.findElement(by);
    }
    public void click(By by){
        //webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(by)));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(findElement(by)));
        findElement(by).click();

    }

    public void sendKeys(By by, String text){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        findElement(by).sendKeys(text);
    }
    public void containsPageUrl(String containsUrl){
        webDriverWait.until(ExpectedConditions.urlContains(containsUrl));
        Assert.assertTrue("Url does not contain "+ containsUrl,webDriver.getCurrentUrl().contains(containsUrl));
    }

    public void checkElementDisplayed(By by){
        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(by)));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        Assert.assertTrue(findElement(by).isDisplayed());
    }

    public void checkPageTitle(String expectedTitle){
        webDriverWait.until(ExpectedConditions.titleIs(expectedTitle));
        Assert.assertEquals(expectedTitle + " is not equal the current page title",expectedTitle, webDriver.getTitle());
    }
    public void checkElementText(By by, String elementText){
        webDriverWait.until(ExpectedConditions.textToBe(by,elementText));
        Assert.assertEquals(elementText + " is not equal the element text",elementText, findElement(by).getText());
    }
    public void checkElementTextUpperCase(By by, String elementText){
        Assert.assertEquals(elementText + " is not equal the element text",elementText.toUpperCase(), findElement(by).getText().toUpperCase());
    }
    public void scrollUntilVisible(By by){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        js.executeScript ("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", findElement(by));
        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(by)));
    }
    public void hoverToElement(By by){
        Actions actions = new Actions(webDriver);
        WebElement webElement = webDriver.findElement(by);
        actions.moveToElement(webElement).moveToElement(webDriverWait.until(ExpectedConditions.elementToBeClickable(by))).build().perform();
    }
    public static int Intcevir(String priceText) {

        priceText = priceText.replace(".", "").replace(",", "").replace(" TL", "").trim();
        return Integer.parseInt(priceText);
    }
    public static int parsePrice(String priceText) {
        if (priceText == null || priceText.trim().isEmpty()) {
            System.out.println("❌ Invalid price: Empty or null");
            return 0; // Default to 0 if input is invalid
        }

        // Remove all non-numeric characters, keeping only digits
        String cleanedPrice = priceText.replaceAll("[^0-9]", "");

        if (cleanedPrice.isEmpty()) {
            System.out.println("❌ Invalid price after cleanup: " + priceText);
            return 0;
        }

        try {
            return Integer.parseInt(cleanedPrice);
        } catch (NumberFormatException e) {
            System.out.println("❌ Number format error for: " + priceText);
            return 0;
        }
    }
    public void sayfaYenile(){
        webDriver.navigate().refresh();
    }

    public void enPahali(By by) {
        sayfaYenile();
        //webDriverWait.until(ExpectedConditions.presenceOfElementLocated(BRANDFILTER));

        List<WebElement> priceElements = webDriver.findElements(by);
        WebElement highestPriceElement = null;
        int maxPrice = 0;

        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().trim(); // Remove spaces
            System.out.println("Found price text: " + priceText); // Debugging output

            int price = parsePrice(priceText); // Safely convert to integer
            if (price > maxPrice) {
                maxPrice = price;
                highestPriceElement = priceElement;
            }
        }

        if (highestPriceElement != null) {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("arguments[0].scrollIntoView(true);", highestPriceElement);
            js.executeScript("arguments[0].click();", highestPriceElement);
        } else {
            System.out.println("❌ Fiyat bulunamadı!");
        }
    }


    public void priceControl(){

        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(PRODUCTDETAILPRICE)));
        WebElement element = webDriver.findElement(PRODUCTDETAILPRICE);
        String fiyat =  element.getText();
        System.out.println(fiyat);
        click(ADDTOCART);
        click(SEPETEGIT);
        WebElement element2 = webDriver.findElement(CARTPRICE);
        String fiyat2 = element2.getText();
        System.out.println(fiyat2);
        Assert.assertEquals(fiyat,fiyat2, "Fiyatlar Aynı");

    }

}
