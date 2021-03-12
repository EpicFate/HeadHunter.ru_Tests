package hh_ru.tests.web;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SearchOnTheSite_Tests {

    @Test
    @AllureId("1843")
    @DisplayName("Поиск резюме")
    @Feature("Поиск по сайту ")
    void resumeSearch() {

        step("Открыть страницу https://hh.ru/employer", (step) -> {
            open("https://hh.ru/employer");
        });

        step("Ввести в строку поиска Qa engineer", (step) -> {
            $("[data-qa='search-input']").val("Qa engineer");
        });

        step("Нажать кнопку Найти сотрудника", (step) -> {
            $(".supernova-search-group__submit ").click();
        });

        step("Проверить что поиск удался", (step) -> {
            $$("[class='resume-search-item']").shouldHaveSize(20);
        });
    }

    @Test
    @AllureId("1844")
    @DisplayName("Поиск вакансии ")
    @Feature("Поиск по сайту ")
    void searchVacancy() {
        step("Открыть страницу https://hh.ru/employer", (step) -> {
            open("https://hh.ru/employer");
        });

        step("Выбрать в поиске вкладку Вакансии", (step) -> {
            $("[data-qa='search-select']").$(byText("Вакансии")).click();
        });

        step("Ввести в строку поиска Qa engineer", (step) -> {
            $("[data-qa='search-input']").val("Qa engineer");
        });

        step("Нажать кнопку Найти сотрудника", (step) -> {
            $(".supernova-search-group__submit ").click();
        });

        step("Проверить что поиск удался", (step) -> {
            $$("[data-qa='vacancy-serp__vacancy']").shouldHaveSize(50);
        });
    }

    @Test
    @AllureId("1845")
    @DisplayName("Поиск Компании")
    @Feature("Поиск по сайту ")
    void searchCompany() {
        step("Открыть страницу https://hh.ru/employer", (step) -> {
            open("https://hh.ru/employer");
        });

        step("Выбрать в поиске вкладку Компании", (step) -> {
            $("[data-qa='search-select']").$(byText("Компании")).click();
        });

        step("Ввести в строку поиска Headhunter", (step) -> {
            $("[data-qa='search-input']").val("Headhunter");
        });

        step("Нажать кнопку Найти сотрудника", (step) -> {
            $(".supernova-search-group__submit ").click();
        });

        step("Проверить что поиск удался", (step) -> {
            $(".l-nopaddings").shouldHave(text("HeadHunter"));
        });
    }
}
