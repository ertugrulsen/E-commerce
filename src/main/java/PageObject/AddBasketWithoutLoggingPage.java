package PageObject;

import driverInstance.Driver;
import gherkin.lexer.Th;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;

public class AddBasketWithoutLoggingPage {
    WebDriver driver;
    WebDriverWait wait;
    public AddBasketWithoutLoggingPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(how = How.XPATH, using = "//li[@id='kitap-muzik-film-hobi']/a/span")
    public WebElement clickBooktab;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Uzaktan Kumandalı Araçlar')]")
    public WebElement clickCarTab;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Diğer Kategoriler')]")
    public WebElement clickOtherCategory;
    @FindBy(how = How.XPATH, using = "//a[contains(@href, '/drone-yedek-parcalari-c-80438115')]")
    public WebElement droneTab;
    @FindBy(how = How.XPATH, using = "//li[2]/div/a/figure/div/img")
    public WebElement clickSecondProduct;
    @FindBy(how = How.XPATH, using = "//form[@id='addToCartForm']/span/button")
    public WebElement addBasket;
    @FindBy(how = How.CSS, using = "#notifications")
    public WebElement notification;
    @FindBy(how = How.ID, using = "cartItemCount")
    public List<WebElement> cart;

    public void Can_Click_Car_Tab() throws InterruptedException {
        Thread.sleep(4000);
        Actions hover = new Actions(driver);
        hover.moveToElement(new WebDriverWait(driver, 5 ).until(ExpectedConditions.elementToBeClickable(clickBooktab))).build().perform();
        Thread.sleep(6000);
        clickCarTab.sendKeys(Keys.ENTER);

    }
    public void Can_Filter_Drone() throws InterruptedException {
        Thread.sleep(3000);
        clickOtherCategory.click();
        droneTab.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }
    public void Can_Select_Product() throws InterruptedException {
        clickSecondProduct.click();
        Thread.sleep(3000);
    }
    public void Can_Add_Basket() throws InterruptedException {

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", addBasket);
        Thread.sleep(3000);
    }
    public void Can_Check_Success_Notification() throws InterruptedException {

        Assert.assertTrue("cart size greater than zero",cart.size()>0);

        driver.quit();
    }
}
