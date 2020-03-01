package PageObject;

import driverInstance.Driver;
import org.junit.Assert;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddBasketWithLoggingPage {
    WebDriver driver;
    WebDriverWait wait;
    public AddBasketWithLoggingPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(how = How.ID, using = "myAccount")
    public WebElement myAccount;
    @FindBy(how = How.ID, using = "login")
    public WebElement login;
    @FindBy(how = How.CLASS_NAME, using = "logout")
    public WebElement logout;
    @FindBy(how = How.ID, using = "email")
    public WebElement Email;
    @FindBy(how = How.ID, using = "password")
    public WebElement Password;
    @FindBy(how = How.CSS, using = "#form-login > div.form-actions > button")
    public WebElement loginClick;
    @FindBy(how = How.ID, using = "productSearch")
    public WebElement searchBox;
    @FindBy(how = How.ID, using = "buttonProductSearch")
    public WebElement searchBoxButton;
    @FindBy(how = How.XPATH, using = "/html/body/div[3]/main/div[2]/div/div/div/div/div[2]/section/div[1]/div[4]/div/div/div/div/ul")
    public List<WebElement>  selectProduct;
    @FindBy(how = How.XPATH, using = "/html/body/div[4]/main/div[3]/section[1]/div[4]/div/div[4]/div[2]/div[2]/div/div[2]/table/tbody/tr/td")
    public List<WebElement> marketList;
    @FindBy(how = How.XPATH, using = "/html/body/div[4]/main/div[3]/section[1]/div[4]/div/div[4]/div[2]/div[2]/div/div[2]/table/tbody/tr/td/div/form/button")
    public List<WebElement> addtwobasket;
    @FindBy(how = How.XPATH, using = "//*[@id='pcwrapper']/div/i")
    public WebElement closePopup;
    @FindBy(how = How.XPATH, using = "//*[@id='shoppingCart']/span[1]")
    public WebElement clickBasketButton;
    @FindBy(how = How.XPATH, using = "//*[@id='form-item-list']/ul/li[1]/div/div[1]/div[1]/a")
    public WebElement vendorName1;
    @FindBy(how = How.XPATH, using = "//*[@id='form-item-list']/ul/li[2]/div/div[1]/div[1]/a")
    public WebElement vendorName2;

    public void Visit_page(){
        driver.get(Driver.BaseAddress());
    }

    public void Can_Go_To_Login_Page() throws InterruptedException {
        Actions action = new Actions(driver);
        Thread.sleep(3000);
        action.moveToElement(myAccount).perform();
        Thread.sleep(3000);
        login.click();
    }
    public void Can_Enter_Credentials(String email, String password) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Thread.sleep(3000);
        Email.sendKeys(email);
        Password.sendKeys(password);
    }
    public void Can_Click_Login_Button(){
        loginClick.sendKeys(Keys.ENTER);
    }

    public void Can_Sarch_Product(String product) throws InterruptedException {
        Thread.sleep(3000);
        searchBox.sendKeys(product);
        Thread.sleep(3000);
        searchBoxButton.sendKeys(Keys.ENTER);
    }
    public void Can_Select_First_Product_In_List() throws InterruptedException {
        Thread.sleep(3000);
        selectProduct.get(0).click();
    }
    public void Can_Add_Basket_For_Two_Vendors() throws InterruptedException {
        Thread.sleep(3000);
        for(int i=0; i<marketList.size();i++) {
            if (i == 2) {
                break;
            }
            addtwobasket.get(i).click();
            String winHandleBefore = driver.getWindowHandle();
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
                Thread.sleep(2000);

            }
            closePopup.click();
            driver.switchTo().window(winHandleBefore);
            Thread.sleep(2000);

        }


    }
    public void Can_Check_Basket() throws InterruptedException {
        clickBasketButton.click();

        Thread.sleep(4000);
        Assert.assertNotEquals(vendorName1.getText(),vendorName2.getText());

        Actions action = new Actions(driver);
        Thread.sleep(3000);
        action.moveToElement(myAccount).perform();
        Thread.sleep(3000);
        logout.click();
        Thread.sleep(5000);

    }
}
