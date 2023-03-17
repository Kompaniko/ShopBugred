package org.bugred;

import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;

import static io.restassured.RestAssured.*;

public class ShopBugred extends  keyClass{
    private int productId;
    public void CreateItem(String nameProduct, String sectionProduct, String descriptionProduct, String colorProduct,  String sizeProduct, double priceProduct, String productParams)
            throws ParseException {

        baseURI = "http://shop.bugred.ru/api/items/create/";

        String jsonShopInfo = "{\"name\":\"" + nameProduct + "\", \"section\":\"" + sectionProduct + "\", " +
                "\"description\":\"" + descriptionProduct + "\", \"color\":\"" + colorProduct + "\", \"size\":\""
                + sizeProduct + "\",\"price\":\"" + priceProduct + "\", \"product\":\"" + productParams + "\", \"photo\":\"" + photoProducts + "\" }";

       String response = given()
                .header("Content-type", "application/json")
                .body(jsonShopInfo)
                .post(baseURI)
                .then().statusCode(200)
                .log().body()
                .extract().response().asString();
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(response);
        productId = Integer.parseInt(json.get("id").toString());
    }

    public void updateItem() {
//        int id = productId;
        String nameProduct = "Футбока Баленсиагааага";
        String sectionProduct = "Верхняя одежда";
        String descriptionProduct = "Зимняя одежда";

        baseURI = "http://shop.bugred.ru/api/items/update/";

        String jsonShopInfo = "{\"id\":\"" + productId + "\", \"name\":\"" + nameProduct + "\", \"section\":\"" + sectionProduct + "\", " +
                "\"description\":\"" +  descriptionProduct +  "\" }";

        given()
                .header("Content-type", "application/json")
                .body(jsonShopInfo)
                .post(baseURI)
                .then().statusCode(200)
                .log().body();
}
    public void updatePhoto(){
        int id = 79;

        baseURI = "http://shop.bugred.ru/api/items/upload_photo/";
        File fileAvatar = new File("/Users/nikita/Downloads/256x256bb.jpg");
        String jsonShopInfo = "{\"id\":\"" + id + "\", \"photo\":\"" + fileAvatar + "\" }";

        given()
                .header("Content-type", "application/json")
                .body(jsonShopInfo)
                .post(baseURI)
                .then().statusCode(200)
                .log().body();
    }

    public void getInfoItem () {

        int id = 80;

        baseURI = "http://shop.bugred.ru/api/items/get/";

        String json = "{\"id\":\"" + id + "\" }";

        given()
                .header("Content-type", "application/json")
                .body(json)
                .post(baseURI)
                .then()
                .statusCode(200)
                .log().body();
    }

    public void getDeleteItem(){
        int id  = 80;

        baseURI = "http://shop.bugred.ru/api/items/delete/";

        String json = "{\"id\":\"" + id + "\" }";

        given()
                .header("Content-type", "application/json")
                .body(json)
                .post(baseURI)
                .then()
                .statusCode(200)
                .log().body();

    }

    public void checkgetInfoItem () {

        int id = 80;

        baseURI = "http://shop.bugred.ru/api/items/get/";

        String json = "{\"id\":\"" + id + "\" }";

        given()
                .header("Content-type", "application/json")
                .body(json)
                .post(baseURI)
                .then()
                .statusCode(200)
                .log().body();
    }
    public void dataBaseInfoItem(){
    String sqlQuery = "select * from items where last_id = 83;";
    baseURI = "http://shop.bugred.ru/api/items/select/";

    given().header("Content-type", "application/json")
            .body("{\"sql_query\": \"" + sqlQuery + "\"}")
            .when()
            .post(baseURI + "get/")
            .then()
            .statusCode(200)
            .log().body();

    }


}