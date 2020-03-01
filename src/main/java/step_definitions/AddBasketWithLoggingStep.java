package step_definitions;

import PageObject.AddBasketWithLoggingPage;
import cucumber.api.java8.En;
import driverInstance.Driver;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Set;


public class AddBasketWithLoggingStep implements En {
            WebDriver driver = Driver.getChromeDriver();

    public AddBasketWithLoggingStep() {
        Given("^User go to home page$", () -> {
            new AddBasketWithLoggingPage(driver).Visit_page();
        });
        And("^User go to login page$", () -> {
            try {
                new AddBasketWithLoggingPage(driver).Can_Go_To_Login_Page();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        And("^User enter \"([^\"]*)\" and \"([^\"]*)\" credentials$", (String arg0, String arg1) ->  {
            try {
                new AddBasketWithLoggingPage(driver).Can_Enter_Credentials(arg0,arg1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        And("^User enter login button$", () -> {
            new AddBasketWithLoggingPage(driver).Can_Click_Login_Button();

        });
        And("^User enter \"([^\"]*)\" on search box$", (String arg0) -> {
            try {
                new AddBasketWithLoggingPage(driver).Can_Sarch_Product(arg0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        And("^User select first product on the list$", () -> {

            try {
                new AddBasketWithLoggingPage(driver).Can_Select_First_Product_In_List();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        When("^For the selected product, Add to basket for two vendors$", ()  -> {
            try {
                new AddBasketWithLoggingPage(driver).Can_Add_Basket_For_Two_Vendors();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        });
        Then("^Check Product in the basket and Logout$", () -> {
            try {
                new AddBasketWithLoggingPage(driver).Can_Check_Basket();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });


    }
}
