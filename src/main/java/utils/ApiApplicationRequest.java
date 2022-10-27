package utils;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;

import java.util.List;

public class ApiApplicationRequest {
    @Step("get services name")
    public static List<String> getServicesName(String url, String basePath
            , Integer statusCode, ContentType contentType) {
        return ApiUtils.getRequest(url, basePath,
                "header", String.class, statusCode, contentType);
    }
}
