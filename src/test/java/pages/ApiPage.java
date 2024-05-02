package pages;

import helper.Endpoint;
import helper.Utility;
import helper.Models;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ApiPage {

    String setUrl, global_id;
    Response res;


    public void prepareUrlFor(String url){
        switch (url) {
            case "GET_ALL_LIST_DATA":
                setUrl = Endpoint.GET_ALL_LIST_DATA;
                break;
            case "GET_DATA_SPECIFIC":
                setUrl = Endpoint.GET_DATA_SPECIFIC;
                break;
            case "GET_DATA_WRONG_ID":
                setUrl = Endpoint.GET_DATA_WRONG_ID;
                break;
            case "GET_POST_CREATE_NEW_DATA":
                setUrl = Endpoint.GET_POST_CREATE_NEW_DATA;
                break;
            default:
                System.out.println("Input right url");
        }
    }
    public void hitApiGetAllListData(){
        res = Models.getAllListData(setUrl);
    }
    public void validationStatusCodeIsEquals(Integer status_code){
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void validationResponseBodyGetListUserData(){
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female", "male");
        assertThat(status.get(0)).isIn("active", "inactive");

    }

    public void validationResponseJsonWithJSONSchema(String filename){
        File JSONFile = Utility.getJSONSchemaFile(filename);
//        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void hitApiGetDataSpecific(){
        res = Models.getListDataSpecific(setUrl);
    }

    public void validationResponseBodyDataSpecific(){
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active","inactive");
    }

    public void hitApiGetDataWrongId(){
        res = Models.getDataWrongId(setUrl);
    }

    public void validationResponseBodyWrongId(){
        JsonPath jsonPathEvaluator = res.jsonPath();
        String message = jsonPathEvaluator.get("message");

        assertThat(message).isIn("Resource not found");
    }

    public void hitApiPostCreateNewData(){
        res = Models.postCreateNewData(setUrl);
        System.out.println(res.getBody().asString());
    }

    public void validationResponseBodyPostCreateNewData(){

        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active","inactive");

        global_id = Integer.toString(id);
    }

    public void hitApiDeleteNewData(){
        res = Models.deleteUser(setUrl, global_id);
    }

}
