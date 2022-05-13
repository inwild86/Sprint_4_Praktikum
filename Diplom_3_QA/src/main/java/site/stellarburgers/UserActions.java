package site.stellarburgers;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import io.restassured.response.ValidatableResponse;

import static org.apache.http.HttpStatus.SC_OK;

public class UserActions extends Specification {
    @Step("Create new user")
    public Response createUser(UserData userData) {
        return given()
                .spec(getBaseSpec())
                .body(userData)
                .when()
                .post(EndpointsUserApi.POST_REGISTER_CUSTOMER);
    }

    @Step("Get Token")
    public String getAccessToken(Response response) {
        String token = response.then()
                .extract()
                .path("accessToken");
        return token.substring(7);
    }

    @Step("Delete user")
    public void deleteCustomer(String token) {
        if (token == null) {
            return;
        }
        given()
                .spec(getBaseSpec())
                .auth().oauth2(token)
                .when()
                .delete(EndpointsUserApi.DELETE_CUSTOMER).then()
                .statusCode(202);
    }

    @Step("Performing a user login request. Login: {credentials.email} Password: {credentials.password}")
    public ValidatableResponse loginUser(User user) {
        return given()
                .spec(getBaseSpec())
                .body(user)
                .when()
                .post(EndpointsUserApi.USER_LOGIN)
                .then()
                .statusCode(SC_OK);
    }
}
