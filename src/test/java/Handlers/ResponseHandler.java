package Handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.Map;

public class ResponseHandler {




        //This is the variable Response with refference  as response and private is an access mmodifier
        private static Response response;


        //This is the construct for this class with response as a parameter
        public ResponseHandler(Response response) {

            this.response = response;
        }


        // this is methos to get the status code for the response
        public  int getstatusCode() {

            return response.getStatusCode();

        }


        //This is the method to get the response body
        public  String getResponseBody() {

            return response.getBody().asPrettyString();

        }


        //This is the method to get the status line
        public  String getstatusLine() {

            return response.getStatusLine();

        }


        //This is the method to get the header
        public   String getHeader(String header){

            return  response.getHeader(header);
        }


        //This is the method to get the content Type
        public   String getContentType(){

            return  response.getContentType();
        }



        //This is the method to get the cookie
        public   String getCookie(String cookie){

            return  response.getCookie(cookie);
        }


        //This is the method to get the headers
        public  Headers getHeaders(){

            return  response.getHeaders();
        }


        //This is the method to get the Cookies
        public  Map<String, String> getCookies(){

            return  response.getCookies();
        }

        //Deserilization
        public  <T> T getResponseObject(Class<T> className) {

            T deserilizateddata=null;

            try{
                deserilizateddata = new ObjectMapper().readValue(response.getBody().asString(), className);

            }catch (JsonProcessingException e){
                e.printStackTrace();

            }
            return deserilizateddata;
        }


}
