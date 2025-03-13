package steps;

import base.BasePage;
import helper.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static constants.HepsiburadaSearchConstants.*;

public class SearchSteps extends BasePage {
    private final Logger logger = LoggerFactory.getLogger(SearchSteps.class);




    @Given("Anasayfa Acilir")
    public void homePage() {
        logger.info("Navigate to the Hb home page");
        navigateUrl(HOME_PAGE_URL);
        containsPageUrl(HOME_PAGE_URL);
    }
    @Then("Anasayfa Kontol Edilir")
    public void homePageCheck() {
        logger.info("Navigate to the Hb home page");
        containsPageUrl(HOME_PAGE_URL);
    }
    @Then("Cerezler Kabul Edilir")
            public void cookies() {
        logger.info("Elektronik Kategorisine Gidiliyor");
        click(COOKIES);
    }
    @Then("Kullanici Elektronik kategorisine gider")
    public void searchKey() {
        logger.info("Elektronik Kategorisine Gidiliyor");
        hoverToElement(ELEKTRONIK);
        click(ELEKTRONIK);
    }

    @Then("Sayfa Kontrol Edilir")
    public void pageCheck() {
        logger.info("Sayfa Kontrol Edilir");
        containsPageUrl(PAGE_URL);
    }

    @Then("Move to Element")
    public void clickSearchIcon() {
        logger.info("Bilgisayar/tablet üzerine kaydırılır");
        hoverToElement(BILGISAYAR);
    }

    @Then("Tablet Secilir")
    public void selectTablet() {
        logger.info("Tablet Seciliyor");
        click(TABLET);
    }
    @Then("Apple seceneğine kaydırılır")
    public void scrollBrand() {
        logger.info("Apple Markası kaydırıldı");
        scrollUntilVisible(APPLE);
        //checkElementDisplayed(APPLE);
    }

    @Then("Apple Markasi Secilir")
    public void selectBrand() {
        logger.info("Apple Markası Secildi");
        click(APPLE);
    }
    @Then("Ekran seceneğine kaydırılır")
    public void scrollScreen() {
        logger.info("Tablet ekran Seçeneğine Kaydırırldı");
        scrollUntilVisible(EKRAN);
    }
    @Then("Ekran Boyutu Secilir")
    public void selectScreen() {
        logger.info("Ekran Boyutu Seciliyor");
        scrollUntilVisible(EKRAN);
        click(EKRAN);
    }
    @Then("Filtreler Kontrol Edilir")
    public void filterControl(){
        containsPageUrl(FILTER_PAGE_URL);
        filterControl();
    }
    @Then("En pahali Urun Secilir")
    public void selectProduct(){
        logger.info("En Pahali Urun");
        enPahali(PRODUCTPRICE);
    }

    @Then("Sepete Ekle")
    public void addToCart(){
        click(ADDTOCART);

    }
    @Then("Fiyat Kontrol")
    public void priceCheck(){
        logger.info("En pahali ürün sepete ekledi ve fiyat karşılaştırması yapıldı");
    priceControl();



    }
    @Then("Sayfa Yeniden Yüklenir")
    public void refreshPage(){
        refreshPage();
    }


}
