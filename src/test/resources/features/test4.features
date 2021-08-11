#language:ru
#encoding:UTF-8

@test @DeletingItemsFromTheTrash
Функционал: Проверка удаления товаров из корзины на сайте Saucedemo

  Сценарий: Проверка, что два товара добавлены в корзину, с проверкой на удаленные товары
    Допустим открыта страница "https://www.saucedemo.com/"
    И в строки логина и пароля введены корректные данные "standard_user; secret_sauce"
    И нажата кнопка "LOGIN"
    Тогда загрузилась страница, с названием шапки PRODUCTS "PRODUCTS"
    И добавим первый и последний товар в корзину "Sauce Labs Backpack, Test.allTheThings() T-Shirt (Red)"
    И выполнено нажатие на кнопку корзины "Your Cart"
    И удалим первый и последний товар из корзины "Delete product"
    И нажатие на кнопку All Items "All Items"
    Тогда загрузилась страница, с названием шапки PRODUCTS "PRODUCTS"