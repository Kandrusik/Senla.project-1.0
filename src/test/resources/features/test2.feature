#language:ru
#encoding:UTF-8

@test @BuyThings
Функционал: Проверка покупки двух товаров на сайте Saucedemo

  Сценарий: Проверка, что два товара добавлены в корзину и куплены, с результатом соощения об успешной покупки
    Допустим открыта страница "https://www.saucedemo.com/"
    И в строки логина и пароля введены корректные данные "standard_user; secret_sauce"
    И нажата кнопка "LOGIN"
    Тогда загрузилась страница, с названием шапки PRODUCTS "PRODUCTS"
    И добавим первый и последний товар в корзину "Sauce Labs Backpack, Test.allTheThings() T-Shirt (Red)"
    И выполнено нажатие на кнопку корзины "Your Cart"
    И выполнено нажатие на кнопку продолжения оформления покупки "Checkout: Your Information"
    И в строки имени, фамилии и почтового кода введены корректные данные "Write user field"
    И нажатие на продолжение покупки после введения данных пользователя "Checkout: Overview "
    И нажатие на кнопку оформления покупки "Checkout: Complete!"
    И загрузилась страница, с названием THANK YOU FOR YOUR ORDER "Successful purchase"