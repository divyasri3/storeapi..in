package Handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/*
This is the class used for  all HTTPS REQUEST METHODS
 */
public class RequestHandler {



    //This method for Get method
    public static Response sendGetRequest(String endpoint) {

        // return the response of the get http request
        return given().header("accept", "application/json")
        .get(endpoint);

    }

    //This method for Post method
    public static Response sendPostRequest(String endpoint, Object requestBody)  {

        //serilization:
        String jsonResponse = null;
        try {
            jsonResponse = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(requestBody);

        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }

        // return the reponse of the post http request
        return given()

                // setting the content type
                .contentType("application/json")

                .header("accept", "application/json")
                //Setting the headers
                .header("contentType", "Application/json")

                // Setting the body with serilizationn
                .body(jsonResponse)

                // sending the post call
                .post(endpoint);

    }

    //This method for Put method

    public static Response sendPutRequest(String endpoint, Object requestBody)  {

        //serilization:
        String jsonResponse = null;
        try {
            jsonResponse = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(requestBody);

        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }


        // return the reponse of the get http request
        return given()

                // setting the content type
                .contentType("application/json")

                //Setting the headers
                .header("contentType", "Application/json")

                // Setting the body with serilization
                .body(jsonResponse)

                // Sending the put call
                .put(endpoint);

    }


    //This method for Delete method
    public static Response sendDeleteRequest(String endpoint) {

        // return the reponse of the delete http request
        return RestAssured.delete(endpoint);

    }

}

