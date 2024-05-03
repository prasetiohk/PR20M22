package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import static helper.Utility.generateRandomEmail;

public class Models {

    private static RequestSpecification request;

    public static void setupHeader(){
        request = RestAssured.given()
                .header("Content-type", "Application/json")
                .header("Accept", "application/json")
                .header("Authorization","Bearer 1dfdb361992d13c0b09a2f558f49de5b0cbe97f08827d4d2867322afdd83e82d");
    }
    public static Response getAllListData (String endpoint) {
        setupHeader();
        return request.when().get(endpoint);
    }
    public static Response getListDataSpecific (String endpoint) {
        setupHeader();
        return request.when().get(endpoint);
    }
    public static Response getDataWrongId (String endpoint) {
        setupHeader();
        return request.when().get(endpoint);
    }
    public static Response postCreateNewData(String endpoint){
        String name = "Prasetio";
        String gender = "male";
        String email = generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeader();
        return request.body(payload.toString()).when().post(endpoint);
    }
    public static Response deleteUser(String endpoint, String user_id){
        setupHeader();
        String finalEndpoint = endpoint + "/" + user_id;
        System.out.println(finalEndpoint);
        return request.when().delete(finalEndpoint);
    }
}
