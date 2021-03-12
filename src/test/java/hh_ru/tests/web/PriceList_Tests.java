package hh_ru.tests.web;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class PriceList_Tests extends TestBase {
    @Test
    @AllureId("1840")
    @DisplayName("Добавление услуги 'Выборка в регионах' в корзину")
    @Tag("smoke")
    @Story("Выборки резюме")
    @Feature("Прайс-лист")
    void addingSelectionInRegionsToTheBasket() {
        step("Открыть страницу https://hh.ru/price/recommended?from=header_new", (step) -> {
            open("https://hh.ru/price/recommended?from=header_new");
        });

        step("Перейти на вкладку Выборки резюме", (step) -> {
            $(".bloko-tabs__items").$(byText("Выборки резюме")).click();
        });

        step("Проверить что вкладка открылась", (step) -> {
            $(".HH-StickyParentAreaResizer-Content").shouldHave(text("Выборка в регионах"));

        });

        step("В столбце Выборка в регионах задать количество", (step) -> {
            $("[data-code='REGIONAL_VSIM']").val("100");
        });

        step("Проверить что сумма изменилась", (step) -> {
            $("[data-qa='cart-item REGIONAL_VSIM']").shouldHave(text("275 000"));
        });

        step("Нажать В корзину", (step) -> {
            $("[data-qa='cart-item REGIONAL_VSIM']").$(byText("В корзину")).click();
        });

        step("Проверить что услуга в корзине", (step) -> {
            $(".price-cart-item__title-text").shouldHave(text("100 выборок резюме для региональной вакансии"));
        });
    }

    @Test
    @AllureId("1839")
    @DisplayName("Добавление услуги 'Вся Россия' в корзину")
    @Tag("smoke")
    @Story("Доступ к базе резюме")
    @Feature("Прайс-лист")
    void addingAllRussiaToTheBasket() {
        step("Открыть страницу https://hh.ru/price/recommended?from=header_new", (step) -> {
            open("https://hh.ru/price/recommended?from=header_new");
        });
        step("Проверить что страница открылась", (step) -> {
            $("[data-qa='cart__page-title']").shouldHave(text("Покупка услуг по подбору персонала в Краснодаре"));
        });

        step("Перейти на вкладку Доступ к базе резюме", (step) -> {
            $(".bloko-tabs__items").$(byText("Доступ к базе резюме")).click();
        });

        step("Проверить что вкладка открылась", (step) -> {
            $x("(//*[@class='price-services-item__header'])[4]").shouldHave(text("Вся Россия"));
        });

        step("В столбце Вся Россия выбрать 3 месяца", (step) -> {
            $x("(//*[@data-qa='cart-item__period'])[4]").selectOption("3 месяца");
        });

        step("Проверить что 3 месяца выбрано верно", (step) -> {
            $("[data-qa='cart-item__publications-included']").shouldHave(text("В пакете с 450 публикациями вакансий «Стандарт»"));
        });

        step("Нажать кнопку В корзину", (step) -> {
//            $("[data-qa='cart-resume-access__button-add']").click();
            $x("(//*[@data-qa='cart-resume-access__button-add'])[4]").click();
        });

        step("Проверить что услуга в корзине", (step) -> {
            $(".price-cart-item__period-and-view-counter").shouldHave(text("3 месяца, 3200 открытий контактов, API HH"));
        });
    }

    @Test
    @AllureId("1837")
    @DisplayName("Добавление услуги 'Премиум' в корзину ")
    @Tag("smoke")
    @Story("Размещение вакансий")
    @Feature("Прайс-лист")
    void addingPremiumToTheCart() {
        step("Открыть страницу https://hh.ru/price/recommended?from=header_new", (step) -> {
            open("https://hh.ru/price/recommended?from=header_new");
        });

        step("Перейти на вкладку Размещение вакансий", (step) -> {
            $(".bloko-tabs__items").$(byText("Размещение вакансий")).click();
        });

        step("Проверить что вкладка открылась", (step) -> {
            $(".bloko-section").shouldHave(text("Премиум"));
        });

        step("В столбце премиум ввести 100 шт.", (step) -> {
            $x("(//*[@data-qa='price__input'])[1]").val("100");
        });

        step("Проверить что сумма изменилась", (step) -> {
            $x("(//*[@class='publication__cost'])[1]").shouldHave(text("637 200 руб."));

        });

        step("Нажать В корзину", (step) -> {
            $x("(//*[@class='bloko-button bloko-button_stretched'])[1]").click();
        });

        step("Проверить что услуга в корзине", (step) -> {
            $(".bloko-modal-content").shouldHave(text("100 вакансий Премиум по 6372"));
        });
    }
}
