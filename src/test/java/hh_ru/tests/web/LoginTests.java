package hh_ru.tests.web;

import hh_ru.allure.Layer;
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
public class LoginTests extends TestBase{
    @Test
    @Tag("smoke")
    @AllureId("1841")
    @DisplayName("Успешная авторизация")
    @Feature("Авторизация")
    void successfulLoginTest() {
        step("Открыть страницу https://hh.ru", (step) -> {
            open("https://hh.ru");
        });

        step("Проверить что страница открылась", (step) -> {
            $(".supernova-dashboard-header").shouldHave(text("Работа найдется для каждого"));
        });

        step("Нажать кнопку Войти", (step) -> {
            $(".supernova-navi_dashboard").$(byText("Войти")).click();
        });

        step("Проверить что страница сменилась", (step) -> {
            $(".account-form-wrapper").shouldHave(text("Вход в личный кабинет"));
        });

        step("Ввести Email", (step) -> {
            $("[data-qa='login-input-username']").val("hhtestqaguru@gmail.com");
        });

        step("Ввести Пароль", (step) -> {
            $("[data-qa='login-input-password']").val("Bb11223344");
        });

        step("Нажать кнопку Войти в личный Кабинет", (step) -> {
            $("[data-qa='account-login-submit']").click();
        });

        step("Поверить что мы зашли в личный кабинет", (step) -> {
            $(".index-dashboard-main-header").shouldHave(text("Найди работу мечты"));
        });
    }

    @Test
    @Tag("smoke")
    @DisplayName("Неудачная авторизация")
    @Feature("Авторизация")
    void unsuccessfulLoginTest() {
        step("Открыть страницу https://hh.ru", (step) -> {
            open("https://hh.ru");
        });

        step("Проверить что страница открылась", (step) -> {
            $(".supernova-dashboard-header").shouldHave(text("Работа найдется для каждого"));
        });

        step("Нажать кнопку Войти", (step) -> {
            $(".supernova-navi_dashboard").$(byText("Войти")).click();
        });

        step("Проверить что страница сменилась", (step) -> {
            $(".account-form-wrapper").shouldHave(text("Вход в личный кабинет"));
        });

        step("Ввести Email", (step) -> {
            $("[data-qa='login-input-username']").val(" ");
        });

        step("Ввести Пароль", (step) -> {
            $("[data-qa='login-input-password']").val(" ");
        });

        step("Нажать кнопку Войти в личный Кабинет", (step) -> {
            $("[data-qa='account-login-submit']").click();
        });

        step("Поверить что мы зашли в личный кабинет", (step) -> {
            $(".index-dashboard-main-header").shouldHave(text("Найди работу мечты"));
        });
    }
}
