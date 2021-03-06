package steps;

import allPages.BasePage;
import allPages.BasketPage;
import allPages.CheckoutPage;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Steps {

    BasePage basePage = new BasePage();
    BasketPage basketPage = new BasketPage();
    CheckoutPage checkoutPage = new CheckoutPage();


    @Когда("^добавляем рюкзак и краснау футболку в корзину$")
    public void addFirstAndSecondProducts() {
        basketPage.scanTableBody()
                .setAddAllItemToCartButton();
    }

    @Тогда("^переходим в корзину и нажимаем Checkout$")
    public void clickOnButtonBasketAndCheckGadgetPrice() {
        basePage.setBasketButton();
        basketPage.setCheckoutButton();
    }

    @И("^заполняем пользовательские данные и нажимаем Continue$")
    public void checkGadgetPrice() {
        checkoutPage.yourPersonInformation("Oleg", "Oleg", "12345")
                .setContinueOrderButton();
    }

    @И("^подтверждаем заказ нажатием на поле Finish$")
    public void clickOnFinishOrderButton() {
        checkoutPage.setFinishOrderButton();
    }


    @Тогда("^загрузилась страница с успешным заказом$")
    public void checkFinishOder() {
        checkoutPage.thankYouForYourOrder.shouldBe(text("THANK YOU FOR YOUR ORDER"));
    }


    @Когда("^выполняем нажатие на ссылку \"([^\"]*)\"$")
    public void checkFinishOder(String link) {
        $(By.xpath("//div[text()=\"" + link + "\"]")).click();
    }


    @Тогда("^цена товара равна \"([^\"]*)\"$")
    public void checkPrice(String price) {
        String actualPriceInfo = $(By.className("inventory_details_price")).getText();
        assertTrue(actualPriceInfo.contains(price), "Актуальная и ожидаемая цена не совпадают");
    }
}