import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class Methods extends BasePage {


    public Methods yourPersonInformation(String firstName, String lastName, String zipCode) {
        firstNameOrder.sendKeys(firstName);
        lastNameOrder.sendKeys(lastName);
        zipCodeField.sendKeys(zipCode);
        return this;
    }

    public Methods scanTableBody() {
        tableBody.shouldBe(visible);
        return this;
    }

    public Methods setBasketButton() {
        basketButton.click();
        return this;
    }

    public Methods setCheckoutButton() {
        checkoutButton.click();
        return this;
    }

    public Methods setContinueOrderButton() {
        continueOrderButton.click();
        return this;
    }

    public Methods setFinishOrderButton() {
        finishOrderButton.click();
        return this;
    }

    public Methods setCancelOrderButton() {
        cancelOrderButton.click();
        return this;
    }

    public Methods setHomeButton() {
        menuButton.click();
        homeButton.click();
        return this;
    }

    public Methods setAddAllItemToCartButton() {
        addItemToCartButton.findBy(text("Add to cart")).click();
        return this;
    }

    public Methods setCancelAllButtonFromCart() {
        cancelButtonFromCart.findBy(text("Remove")).click();
        return this;
    }
}