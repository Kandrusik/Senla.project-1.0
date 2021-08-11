package steps;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Тогда;
import java.io.IOException;

import allPages.BasketPage;
import allPages.CheckoutPage;
import allPages.LoginPage;


import static com.codeborne.selenide.Condition.text;

public class Steps {

    @Допустим("^открыта страница \"([^\"]*)\"$")
    public void openPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();
    }

    @Допустим("^в строки логина и пароля введены корректные данные \"([^\"]*)\"$")
    public void enterValue() throws IOException {
        LoginPage loginPage = new LoginPage();
        loginPage.writeFieldsUser();
    }

    @Допустим("^нажата кнопка \"([^\"]*)\"$")
    public void clickOnButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.signInButton.click();
    }

    @Тогда("^загрузилась страница, с названием шапки PRODUCTS \"([^\"]*)\"$")
    public void coverNameCheck() {
        LoginPage loginPage = new LoginPage();
        loginPage.welcomeMessage.shouldHave(text("PRODUCTS"));
    }

    @Тогда("^добавим первый и последний товар в корзину \"([^\"]*)\"$")
    public void addFirstAndSecondProducts() {
        BasketPage basketPage = new BasketPage();
        basketPage.scanTableBody()
                .setAddAllItemToCartButton();
    }

    @Тогда("^выполнено нажатие на кнопку корзины \"([^\"]*)\"$")
    public void clickOnButtonBasket() {
        BasketPage basketPage = new BasketPage();
        basketPage.setBasketButton();
    }

    @Тогда("^выполнено нажатие на кнопку продолжения оформления покупки \"([^\"]*)\"$")
    public void checkGadgetPrice() {
        BasketPage basketPage = new BasketPage();
        basketPage.setCheckoutButton();
    }

    @Тогда("^в строки имени, фамилии и почтового кода введены корректные данные \"([^\"]*)\"$")
    public void writeCorrectUserField() {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.yourPersonInformation("Oleg", "Oleg", "12345");
    }

    @Тогда("^нажатие на продолжение покупки после введения данных пользователя \"([^\"]*)\"$")
    public void clickOnContinueOrderButton() {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.setContinueOrderButton();
    }

    @Тогда("^нажатие на кнопку оформления покупки \"([^\"]*)\"$")
    public void clickOnFinishOrderButton() {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.setFinishOrderButton();
    }

    @Тогда("^загрузилась страница, с названием THANK YOU FOR YOUR ORDER \"([^\"]*)\"$")
    public void checkFinishOder() {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.thankYouForYourOrder.shouldBe(text("THANK YOU FOR YOUR ORDER"));
    }

    @Тогда("^нажатие на кнопку отмены покупки \"([^\"]*)\"$")
    public void cancelFinishOder() {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.setCancelOrderButton();
    }

    @Тогда("^удалим первый и последний товар из корзины \"([^\"]*)\"$")
    public void cancelAllButtonFromCart() {
        BasketPage basketPage = new BasketPage();
        basketPage.setCancelAllButtonFromCart();
    }

    @Тогда("^нажатие на кнопку All Items \"([^\"]*)\"$")
    public void clickHomeButton() {
        BasketPage basketPage = new BasketPage();
        basketPage.setHomeButton();
    }
}