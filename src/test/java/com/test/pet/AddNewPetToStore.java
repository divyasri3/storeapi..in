package com.test.pet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.pet.pojo.pet.Category;
import com.test.pet.pojo.pet.Pet;
import com.test.pet.pojo.pet.Tag;
import  io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
{
  "id": 0,
  "category": {
    "id": 0,
    "name": "string"
  },
  "name": "doggie",
  "photoUrls": [
    "string"
  ],
  "tags": [
    {
      "id": 0,
      "name": "string"
    }
  ],
  "status": "available"
}
 */
public class AddNewPetToStore {
@Test
    public static void testAddingNewPetToStore() throws JsonProcessingException {

        Pet p = new Pet();
        p.setId(1);
        Category c = new Category();
        c.setId(10);
        c.setName("lab dogs");
        p.setCategory(c);
        p.setName("ragi java");
        List<String> l = new ArrayList<>();
        l.add("C:\\Users\\DIVYA\\Pictures\\srih1.jpg");
        p.setPhotoUrls(l);
        Tag t= new Tag();
        t.setId(100);
        t.setName("very good and decent dog in the world ");
        List<Tag> tag = new ArrayList<>();
        tag.add(t);
        p.setTags(tag);
        p.setStatus("available");


        String petJson=new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(p);
        System.out.println(petJson);
        RequestSpecification httpRequest = RestAssured.given()
                .header("contentType", "application/json")
                .header("accept","application/json")
                .contentType("Application/json")
                .body(petJson)
                .baseUri("https://petstore.swagger.io/v2/pet");
                //.pathParams("l","pet");

        Response res = httpRequest.request(Method.POST, "");
    System.out.println(res.body().asPrettyString());

    //Pet petJava = new ObjectMapper().readValues(petJson, Pet.class);

    }

@Test
    public  void testUploadAnImageOfPet(){


        RequestSpecification httpRequest = RestAssured.given()
                .header("contentType", " multipart/form-data")
                .header("accept","application/json")
                //.contentType("Application/json")
                .formParam("additionalMetadata","this is good and tall enough")
                .multiPart("file",new File("C:\\Users\\DIVYA\\Pictures\\srih1.jpg"),"image/png")
                .baseUri("https://petstore.swagger.io/v2/pet/1/uploadImage");
        //.pathParams("l","pet");

        Response res = httpRequest.request(Method.POST, "");
        System.out.println(res.body().asPrettyString());

    }

@Test
    public void testUpdateAPetUsingFormData(){

        RequestSpecification httpRequest = RestAssured.given()
                .header("contentType", "  application/x-www-form-urlencoded")
                .header("accept","application/json")
                .contentType(" application/x-www-form-urlencoded")
                .formParam("name","div")
                .formParam("status","available")

                .baseUri("https://petstore.swagger.io/v2/pet/1");
        //.pathParams("l","pet");

        Response res = httpRequest.request(Method.POST, "");
        System.out.println(res.body().asPrettyString());

    }
@Test
    public void testGetPetDetailById(){

        RequestSpecification httpRequest = RestAssured.given()
                .header("accept","application/json")
                .baseUri("https://petstore.swagger.io/v2/pet/1");
        //.pathParams("petId",1);

        Response res = httpRequest.request(Method.GET, "");
        System.out.println(res.body().asPrettyString());



    }
    @Test
    public void testGetPetDetailByStatus(){

        RequestSpecification httpRequest = RestAssured.given()
                .header("accept","application/json")
                .queryParam("status","available")

                .baseUri(  "https://petstore.swagger.io/v2/pet/findByStatus");
        //.pathParams("petId",1);

        Response res = httpRequest.request(Method.GET, "");
        System.out.println(res.body().asPrettyString());



    }
    @Test
    public void testDeletePetUsingId(){

        RequestSpecification httpRequest = RestAssured.given()
                .header("accept","application/json")
                .header("api_key","special-key")
                .baseUri(  "https://petstore.swagger.io/v2/pet/1");

        Response res = httpRequest.request(Method.DELETE, "");
        System.out.println(res.body().asPrettyString());




    }

}