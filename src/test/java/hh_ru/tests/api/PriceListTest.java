package hh_ru.tests.api;

import hh_ru.allure.Layer;
import hh_ru.config.ApiConfigHelper;
import hh_ru.model.ToTheBasketModel;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static hh_ru.report.Report.filters;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Layer("api")
@Owner("EpicFate")
public class PriceListTest {

    @Test
    @AllureId("1894")
    @Story("Доступ к базе резюме")
    @DisplayName("Добавление услуги 'Вся Россия' в корзину")
    @Tag("smoke")
    @Feature("Прайс-лист")
    public void addingAllRussiaToTheBasket() {
        String body = ApiConfigHelper.getBody();
        String cookie = ApiConfigHelper.getCookie();
        String contentType = ApiConfigHelper.getContentType();
        String post = ApiConfigHelper.getPost();
        String header = ApiConfigHelper.getHeader();

        ToTheBasketModel response = given()
                .contentType(contentType)
                .cookie(cookie)
                .header("X-Xsrftoken", header)
                .body(body)
                .filter(filters().customTemplates())
                .log().uri()
                .when()
                .post(post)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(ToTheBasketModel.class);

        assertEquals(response.getCost(), 254800.0);
    }
}
