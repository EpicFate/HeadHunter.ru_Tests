package ru.hh.tests.web;

import ru.hh.allure.Layer;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Layer("web")
@Owner("EpicFate")
public class SearchOnTheSiteTests extends TestBase {

    @Test
    @AllureId("1843")
    @DisplayName("Поиск резюме")
    @Feature("Поиск по сайту ")
    void resumeSearch() {

        step("Открыть страницу https://hh.ru/employer", () ->
                open("https://hh.ru/employer"));

        step("Ищем резюме", () -> {
            step("Ввести в строку поиска Qa engineer", () ->
                    $("[data-qa='search-input']").val("Qa engineer"));
            step("Нажать кнопку Найти сотрудника", () ->
                    $(".supernova-search-group__submit ").click());
        });

        step("Проверить что поиск удался", () ->
                $$("[class='resume-search-item']").shouldHaveSize(20));
    }

    @Test
    @AllureId("1844")
    @DisplayName("Поиск вакансии ")
    @Feature("Поиск по сайту ")
    void searchVacancy() {
        step("Открыть страницу https://hh.ru/employer", () ->
                open("https://hh.ru/employer"));

        step("Ищем вакансии", () -> {
            step("Выбрать в поиске вкладку Вакансии", () ->
                    $("[data-qa='search-select']").$(byText("Вакансии")).click());
            step("Ввести в строку поиска Qa engineer", () ->
                    $("[data-qa='search-input']").val("Qa engineer"));
            step("Нажать кнопку Найти сотрудника", () ->
                    $(".supernova-search-group__submit ").click());
        });

        step("Проверить что поиск удался", () ->
                $$("[data-qa='vacancy-serp__vacancy']").shouldHaveSize(40));
    }

    @Test
    @AllureId("1845")
    @DisplayName("Поиск Компании")
    @Feature("Поиск по сайту ")
    void searchCompany() {
        step("Открыть страницу https://hh.ru/employer", () ->
                open("https://hh.ru/employer"));

        step("Ищем сотрудника", () -> {
            step("Выбрать в поиске вкладку Компании", () ->
                    $("[data-qa='search-select']").$(byText("Компании")).click());
            step("Ввести в строку поиска Headhunter", () ->
                    $("[data-qa='search-input']").val("Headhunter"));
            step("Нажать кнопку Найти сотрудника", () ->
                    $(".supernova-search-group__submit ").click());
        });

        step("Проверить что поиск удался", () ->
                $(".l-nopaddings").shouldHave(text("HeadHunter")));
    }
}
