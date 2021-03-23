package com.ayo.conversion;

import com.ayo.conversion.dao.ConversionResponseResource;
import com.ayo.conversion.rest.ConversionController;
import com.ayo.conversion.util.UnitOfMeasure;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConversionControllerTest {

    @LocalServerPort
    private int port;

    private Gson gson;

    @Before
    public void setUp() {
        RestAssured.port = port;
        gson = new Gson();
    }

    @Test
    public void testConvertMileToKilometerSuccessfully () {

        String response = given()
                .contentType(ContentType.JSON)
                .auth()
                .none()
                .when()
                .get(ConversionController.KILOMETER_URI +"/60")
                .then()
                .statusCode(HttpStatus.OK.value()).extract().asString();

        ConversionResponseResource resource = gson.fromJson(response, ConversionResponseResource.class);
        assertEquals(UnitOfMeasure.KILOMETER.getDescription(), resource.getUnitOfMeasure());
    }

    @Test
    public void testConvertKilometerToMileSuccessfully () {

        String response = given()
                .contentType(ContentType.JSON)
                .auth()
                .none()
                .when()
                .get(ConversionController.MILE_URI+"/250")
                .then()
                .statusCode(HttpStatus.OK.value()).extract().asString();

        ConversionResponseResource resource = gson.fromJson(response, ConversionResponseResource.class);
        assertEquals(UnitOfMeasure.MILE.getDescription(), resource.getUnitOfMeasure());
    }

    @Test
    public void testConvertCelciusToFahrenheitSuccessfully () {

        String response = given()
                .contentType(ContentType.JSON)
                .auth()
                .none()
                .when()
                .get(ConversionController.FAHRENHEIT_URI+"/18")
                .then()
                .statusCode(HttpStatus.OK.value()).extract().asString();

        ConversionResponseResource resource = gson.fromJson(response, ConversionResponseResource.class);
        assertEquals(UnitOfMeasure.FAHRENHEIT.getDescription(), resource.getUnitOfMeasure());
    }

    @Test
    public void testConvertFahrenheitToCelsiusSuccessfully () {

        String response = given()
                .contentType(ContentType.JSON)
                .auth()
                .none()
                .when()
                .get(ConversionController.CELSIUS_URI+"/8")
                .then()
                .statusCode(HttpStatus.OK.value()).extract().asString();

        ConversionResponseResource resource = gson.fromJson(response, ConversionResponseResource.class);
        assertEquals(UnitOfMeasure.CELSIUS.getDescription(), resource.getUnitOfMeasure());
    }

    @Test
    public void testConvertPoundToKilogramSuccessfully () {

        String response = given()
                .contentType(ContentType.JSON)
                .auth()
                .none()
                .when()
                .get(ConversionController.KILOGRAM_URI+"/10")
                .then()
                .statusCode(HttpStatus.OK.value()).extract().asString();

        ConversionResponseResource resource = gson.fromJson(response, ConversionResponseResource.class);
        assertEquals(UnitOfMeasure.KILOGRAM.getDescription(), resource.getUnitOfMeasure());
    }

    @Test
    public void failConvertCelciusToFahrenheitTest () {

        given()
                .contentType(ContentType.JSON)
                .auth()
                .none()
                .when()
                .get(ConversionController.FAHRENHEIT_URI+"/jfvgh")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void failConvertFahrenheitToCelsiusTest () {

        given()
                .contentType(ContentType.JSON)
                .auth()
                .none()
                .when()
                .get(ConversionController.CELSIUS_URI+"/854dfs")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void failConvertPoundToKilogramTest () {

        given()
                .contentType(ContentType.JSON)
                .auth()
                .none()
                .when()
                .get(ConversionController.KILOGRAM_URI+"/^44--")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void failConvertMileToKilometerTest () {

        given()
                .contentType(ContentType.JSON)
                .auth()
                .none()
                .when()
                .get(ConversionController.KILOMETER_URI +"/!!!&&&")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void failConvertKilometerToMileTest () {

        given()
                .contentType(ContentType.JSON)
                .auth()
                .none()
                .when()
                .get(ConversionController.MILE_URI+"/fail")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }
}
