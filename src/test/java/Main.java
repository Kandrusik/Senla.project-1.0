import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWebDriver;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Main {


    @BeforeEach
    public void setUp() {
//        Configuration.headless = true;
        Configuration.startMaximized = true;
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
    public void BuyThings() throws IOException {
        LoginPage loginPage = new LoginPage();
        Methods methods = new Methods();
        loginPage.openLoginPage()
                .singIn();
        methods.scanTableBody()
                .setAddAllItemToCartButton()
                .setBasketButton()
                .setCheckoutButton()
                .yourPersonInformation("Oleg", "Oleg", "12345")
                .setContinueOrderButton()
                .setFinishOrderButton()
                .thankYouForYourOrder.shouldBe(text("THANK YOU FOR YOUR ORDER"));
    }


    @Test
    @Order(3)
    public void CancelOfBuyingThings() throws IOException {
        LoginPage loginPage = new LoginPage();
        Methods methods = new Methods();
        loginPage.openLoginPage()
                .singIn();
        methods.scanTableBody()
                .setAddAllItemToCartButton()
                .setBasketButton()
                .setCheckoutButton()
                .yourPersonInformation("Oleg", "Oleg", "12345")
                .setContinueOrderButton()
                .setCancelOrderButton()
                .welcomeMessage.shouldHave(text("PRODUCTS"));
    }


    @Test
    @Order(4)
    public void DeletingItemsFromTheTrash() throws IOException {
        LoginPage loginPage = new LoginPage();
        Methods methods = new Methods();
        loginPage.openLoginPage()
                .singIn();
        methods.scanTableBody()
                .setAddAllItemToCartButton()
                .setBasketButton()
                .setCancelAllButtonFromCart()
                .setHomeButton()
                .shoppingCartBadge.shouldNotHave(visible);
    }


    @Test
    @Order(5)
    public void CheckingTheTotalAmount() throws IOException {
        LoginPage loginPage = new LoginPage();
        Methods methods = new Methods();
        loginPage.openLoginPage()
                .singIn();
        methods.scanTableBody()
                .setAddAllItemToCartButton()
                .setBasketButton()
                .setCheckoutButton()
                .yourPersonInformation("Oleg", "Oleg", "12345")
                .setContinueOrderButton();
//        Assertions.assertEquals(methods.inventoryItemPrice, methods.summarySubtotalLabel);
    }
}