package utils;


import io.restassured.http.ContentType;
import utils.models.BaseModel;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiUtils {
    public static <Q> List<Q> getRequest(String url, String basePath, String path
            , Class<Q> modelsType, Integer expectCode, ContentType contentType) {
        LoggerUtils.logInfo(ApiUtils.class.getName(), "Get list of models");
        List<Q> elements = given()
                .baseUri(url).basePath(basePath)
                .when().get()
                .then().statusCode(expectCode).contentType(contentType).extract().body().jsonPath().getList(path, modelsType);
        return elements;
    }


    public static <Q extends BaseModel> BaseModel postRequest(String url, String path, BaseModel model, Class<Q> modelType, Integer expectCode) {
        LoggerUtils.logInfo(ApiUtils.class.getName(), "Post request");
        BaseModel model1 = given()
                .baseUri(url)
                .basePath(path)
                .contentType(ContentType.JSON)
                .body(model)
                .when().post()
                .then()
                .statusCode(expectCode)
                .extract().as(modelType);
        return model1;
    }
}
