import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasePage {


    // Constant button
    SelenideElement basketButton = $("#shopping_cart_container > a");
    SelenideElement sighOutButton = $(By.id("logout_sidebar_link"));
    SelenideElement menuButton = $("#react-burger-menu-btn");
    SelenideElement homeButton = $("#inventory_sidebar_link");
    SelenideElement shoppingCartLink = $(By.id(".shopping_cart_link"));
    SelenideElement shoppingCartBadge = $(By.id(".shopping_cart_badge"));


    // Field Person
    SelenideElement firstNameOrder = $("#first-name");
    SelenideElement lastNameOrder = $("#last-name");
    SelenideElement zipCodeField = $("#postal-code");


    // Field with products
    SelenideElement tableBody = $(".inventory_list");
    ElementsCollection cancelButtonFromCart = $$(".btn_small");
    ElementsCollection addItemToCartButton = $$(".btn_primary");


    // Message text
    SelenideElement welcomeMessage = $(By.xpath("//span[text()='Products']"));
    SelenideElement thankYouForYourOrder = $("#checkout_complete_container > h2");
    SelenideElement totalOrderMessage = $(".summary_subtotal_label");


    // Other Button
    SelenideElement cancelOrderButton = $("#cancel");
    SelenideElement continueOrderButton = $("#continue");
    SelenideElement checkoutButton = $("#checkout");
    SelenideElement finishOrderButton = $("#finish");
    SelenideElement continueShoppingButton = $("#continue-shopping");
}