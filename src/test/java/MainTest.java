import allPages.BasePage;
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
public class MainTest extends BasePage {

    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    BasketPage basketPage = new BasketPage();

    @BeforeEach
    public void setUp() throws IOException {
        Configuration.headless = true;
//        Configuration.startMaximized = true;
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
    public void testLoginTest() throws IOException {
        loginPage.openLoginPage()
                .singIn()
                .welcomeMessage.shouldHave(text("PRODUCTS"));
    }


    @Test
    @Order(2)
    public void testBuyThings() {
        basketPage.scanTableBody()
                .setAddAllItemToCartButton();
        basePage.setBasketButton();
        basketPage.setCheckoutButton();
        checkoutPage.yourPersonInformation("Oleg", "Oleg", "12345")
                .setContinueOrderButton()
                .setFinishOrderButton()
                .thankYouForYourOrder.shouldBe(text("THANK YOU FOR YOUR ORDER"));
    }


    @Test
    @Order(3)
    public void testCancelOfBuyingThings() {
        basketPage.scanTableBody()
                .setAddAllItemToCartButton();
        basePage.setBasketButton();
        basketPage.setCheckoutButton();
        checkoutPage.yourPersonInformation("Oleg", "Oleg", "12345")
                .setContinueOrderButton()
                .setCancelOrderButton();
        loginPage.welcomeMessage.shouldHave(text("PRODUCTS"));
    }


    @Test
    @Order(4)
    public void testDeletingItemsFromTheTrash() {
        basketPage.scanTableBody()
                .setAddAllItemToCartButton();
        basePage.setBasketButton();
        basketPage.setCancelAllButtonFromCart();
        basePage.setHomeButton()
                .shoppingCartBadge.shouldBe(hidden);
    }


    @Test
    @Order(5)
    public void testCheckingTheTotalAmount() {
        basketPage.scanTableBody()
                .setAddAllItemToCartButton();
        basePage.setBasketButton();
        basketPage.setCheckoutButton();
        checkoutPage.yourPersonInformation("Oleg", "Oleg", "12345")
                .setContinueOrderButton()
                .stringPriceToDouble();
    }
}