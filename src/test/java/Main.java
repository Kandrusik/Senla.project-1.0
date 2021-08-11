import allPages.BasketPage;
import allPages.CheckoutPage;
import allPages.LoginPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.closeWebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Main {


    @BeforeEach
    public void setUp() throws IOException {
        Configuration.headless = true;
//        Configuration.startMaximized = true;
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage()
                .singIn()
                .welcomeMessage.shouldHave(text("PRODUCTS"));
    }


    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }


    @Test
    @Order(1)
    public void loginTest() throws IOException {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage()
                .singIn()
                .welcomeMessage.shouldHave(text("PRODUCTS"));
    }


    @Test
    @Order(2)
    public void BuyThings() {
        CheckoutPage checkoutPage = new CheckoutPage();
        BasketPage basketPage = new BasketPage();
        basketPage.scanTableBody()
                .setAddAllItemToCartButton()
                .setBasketButton();
        basketPage.setCheckoutButton();
        checkoutPage.yourPersonInformation("Oleg", "Oleg", "12345")
                .setContinueOrderButton()
                .setFinishOrderButton()
                .thankYouForYourOrder.shouldBe(text("THANK YOU FOR YOUR ORDER"));
    }


    @Test
    @Order(3)
    public void CancelOfBuyingThings() {
        BasketPage basketPage = new BasketPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        LoginPage loginPage = new LoginPage();
        basketPage.scanTableBody()
                .setAddAllItemToCartButton()
                .setBasketButton();
        basketPage.setCheckoutButton();
        checkoutPage.yourPersonInformation("Oleg", "Oleg", "12345")
                .setContinueOrderButton()
                .setCancelOrderButton();
        loginPage.welcomeMessage.shouldHave(text("PRODUCTS"));
    }


    @Test
    @Order(4)
    public void DeletingItemsFromTheTrash() {
        BasketPage basketPage = new BasketPage();
        basketPage.scanTableBody()
                .setAddAllItemToCartButton()
                .setBasketButton();
        basketPage.setCancelAllButtonFromCart()
                .setHomeButton()
                .shoppingCartBadge.shouldBe(hidden);
    }


    @Test
    @Order(5)
    public void CheckingTheTotalAmount() {
        BasketPage basketPage = new BasketPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        basketPage.scanTableBody()
                .setAddAllItemToCartButton()
                .setBasketButton();
        basketPage.setCheckoutButton();
        checkoutPage.yourPersonInformation("Oleg", "Oleg", "12345")
                .setContinueOrderButton()
                .stringPriceToDouble();
    }
}