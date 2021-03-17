package ru.hh.tests.web;

import ru.hh.allure.Layer;
import ru.hh.config.ConfigHelper;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Layer("web")
@Owner("EpicFate")
public class LoginTests extends TestBase {

    @Test
    @Tag("smoke")
    @AllureId("1841")
    @DisplayName("Успешная авторизация")
    @Feature("Авторизация")
    void successfulLoginTest() {
        String Email = ConfigHelper.getHHruEmail();
        String Password = ConfigHelper.getHHruPassword();

        step("Открыть страницу https://hh.ru", () ->
                open("https://hh.ru"));


        step("Проверить что страница открылась", () ->
                $(".supernova-dashboard-header").shouldHave(text("Работа найдется для каждого")));


        step("Нажать кнопку Войти", () ->
                $(".supernova-navi_dashboard").$(byText("Войти")).click());


        step("Проверить что страница сменилась", () ->
                $(".account-form-wrapper").shouldHave(text("Вход в личный кабинет")));

        step("Заполнить форму", () -> {

            step("Ввести Email", () ->
                    $("[data-qa='login-input-username']").val(Email));


            step("Ввести Пароль", () ->
                    $("[data-qa='login-input-password']").val(Password));

            step("Нажать кнопку Войти в личный Кабинет", () ->
                    $("[data-qa='account-login-submit']").click());
        });

        step("Поверить что мы зашли в личный кабинет", () ->
                $(".index-dashboard-main-header").shouldHave(text("Найди работу мечты")));

    }

    @Test
    @Tag("smoke")
    @DisplayName("Неудачная авторизация")
    @Feature("Авторизация")
    void unsuccessfulLoginTest() {
        step("Открыть страницу https://hh.ru", () ->
                open("https://hh.ru"));

        step("Проверить что страница открылась", () ->
                $(".supernova-dashboard-header").shouldHave(text("Работа найдется для каждого")));

        step("Нажать кнопку Войти", () ->
                $(".supernova-navi_dashboard").$(byText("Войти")).click());

        step("Проверить что страница сменилась", () ->
                $(".account-form-wrapper").shouldHave(text("Вход в личный кабинет")));

        step("Заполнить форму", () -> {

            step("Ввести Email", () ->
                    $("[data-qa='login-input-username']").val("33333"));

            step("Ввести Пароль", () ->
                    $("[data-qa='login-input-password']").val("33333"));

            step("Нажать кнопку Войти в личный Кабинет", () ->
                    $("[data-qa='account-login-submit']").click());
        });

        step("Поверить что мы зашли в личный кабинет", () ->
                $(".index-dashboard-main-header").shouldHave(text("Найди работу мечты")));
    }
}
