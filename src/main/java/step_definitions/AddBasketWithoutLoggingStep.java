package step_definitions;

import PageObject.AddBasketWithoutLoggingPage;
import cucumber.api.java8.En;
import driverInstance.Driver;
import org.openqa.selenium.WebDriver;

public class AddBasketWithoutLoggingStep implements En {
            WebDriver driver = Driver.getChromeDriver();
    public AddBasketWithoutLoggingStep() {
        And("^User click Uzaktan Kumandali Araclar tab$", () -> {
            try {
                new AddBasketWithoutLoggingPage(driver).Can_Click_Car_Tab();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        And("^User filter for Drone Yedek Parça$", () -> {

            try {
                new AddBasketWithoutLoggingPage(driver).Can_Filter_Drone();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        And("^User select a product in a list$", () -> {
            try {
                new AddBasketWithoutLoggingPage(driver).Can_Select_Product();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        When("^User add product to the basket$", () -> {

            try {
                new AddBasketWithoutLoggingPage(driver).Can_Add_Basket();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Then("^Check success notification message$", () -> {

            try {
                new AddBasketWithoutLoggingPage(driver).Can_Check_Success_Notification();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });



    }
}
