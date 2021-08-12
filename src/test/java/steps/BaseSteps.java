package steps;

import allPages.LoginPage;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;

public class BaseSteps {

    LoginPage loginPage = new LoginPage();

    @Допустим("^открыта страница https://www.saucedemo.com/$")
    public void openPage() {
        Configuration.startMaximized = true;
        loginPage.openLoginPage();
    }

    @И("^вводим корректные данные логина, пароля и авторизуется$")
    public void enterValue() throws IOException {
        loginPage.singIn();
    }

    @Тогда("^загрузилась страница, с названием шапки PRODUCTS$")
    public void coverNameCheck() {
        loginPage.welcomeMessage.shouldHave(text("PRODUCTS"));
    }
}