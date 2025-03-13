package constants;

import org.openqa.selenium.By;

public class HepsiburadaSearchConstants {
    public static final By ELEKTRONIK = By.xpath("//li[@class='sf-MenuItems-WulWXvlfIAwNiOUGY7FP'][1]");
    public static final By COOKIES = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");
    public static final String HOME_PAGE_TITLE = "Türkiye'nin En Çok Tavsiye Edilen E-ticaret Markası Hepsiburada";
    public static final By BILGISAYAR = By.xpath("//a[contains(.,'Bilgisayar/Tablet')]");
    public static final By TABLET = By.xpath("//a[@href='https://www.hepsiburada.com/tablet-c-3008012']");
    public static final String HOME_PAGE_URL = "https://www.hepsiburada.com/";
    public static final String PAGE_URL = "https://www.hepsiburada.com/tablet-c-3008012";
    public static final By APPLE = By.xpath("//a[@title='Apple Tablet' and contains(@href, '/apple-tablet')]");
    public static final By EKRAN = By.xpath("//*[@value=\"13€2C2€20in€C3€A7\"]");
    public static final By PRODUCTPRICE = By.xpath("//div[@data-test-id='price-area']");
    public static final By FILTERS = By.xpath("//div[contains(.,'Ekran Boyutu13,2 inç')]");
    public static final String FILTER_PAGE_URL = "https://www.hepsiburada.com/apple/tablet-c-3008012?filtreler=ekranboyutu:13%E2%82%AC2C2%E2%82%AC20in%E2%82%ACC3%E2%82%ACA7";
    public static final String BRANDFILTERURL = "https://www.hepsiburada.com/apple-tablet-xc-3008012-b8849";
    public static final By ADDTOCART = By.xpath("//*[@data-test-id=\"addToCart\"]");
    public static final By PRODUCTDETAILPRICE = By.xpath("//*[@id=\"container\"]/div/main/div/div/div[2]/section[1]/div[2]/div[3]/div/div[1]/div[1]");
    public static final By SEPETEGIT = By.xpath("//button[contains(.,'Sepete git')]");
    public static final By CARTPRICE = By.xpath("//*[@id=\"0d29c60f-02bc-48cd-9fb8-7f5744d01db8\"]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]");
    public static final By BRANDFILTER = By.xpath("(//*[@class=\"appliedVerticalFilter-pSOYt8wpwv9fUK7bNUjk\"])[2]");
}