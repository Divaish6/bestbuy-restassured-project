package com.bestbuy.testsuite;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest extends TestBase {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {

        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
    }


    // 21. Extract the limit
    @Test
    public void testLimit() {
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    // 22. Extract the total
    @Test
    public void testTotal() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    // 23. Extract the name of 5th product
    @Test
    public void testExtractNameProduct() {
        String nameofproduct = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th product is : " + nameofproduct);
        System.out.println("------------------End of Test---------------------------");
    }

    // 24. Extract the names of all the products
    @Test
    public void testExtractAllNameProduct() {
        List<String> nameofAllProduct = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of all the products is : " + nameofAllProduct);
        System.out.println("------------------End of Test---------------------------");
    }


    // 25. Extract the productId of all the products
    @Test
    public void testExtractAllNameProductId() {
        List<Objects> idOfAllProduct = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The productId of all the products is : " + idOfAllProduct);
        System.out.println("------------------End of Test---------------------------");
    }

    // 26. Print the size of the data list
    @Test
    public void testPrintTheSize() {
        List<HashMap<String, ?>> sizeOfAllProduct = response.extract().path("data.");
        int listsize = sizeOfAllProduct.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Print size of the data list is : " + listsize);
        System.out.println("------------------End of Test---------------------------");
    }


    // 27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void testAllValueOfTheProduct() {
        List<HashMap<String, ?>> productvalue = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product where product name = Energizer - MAX Batteries AA (4-Pack) is : " + productvalue);
        System.out.println("------------------End of Test---------------------------");
    }


    // 28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2- Pack)
    @Test
    public void testModelOfTheProductName() {
        List<String> productname = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}.model");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product where product name = Energizer - N Cell E90 Batteries (2- Pack) is : " + productname);
        System.out.println("------------------End of Test---------------------------");
    }

    // 29. Get all the categories of 8th products
    @Test
    public void testAllTheCategoriesOfProduct() {
        List<HashMap<String, ?>> categories = response.extract().path("data[7].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The categories of 8th products) is : " + categories);
        System.out.println("------------------End of Test---------------------------");
    }

    // 30. Get categories of the store where product id = 150115
    @Test
    public void testCategoriesOfTheStoreProduct() {
        List<String> categories = response.extract().path("data[3].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store where product id = 15011) is : " + categories);
        System.out.println("------------------End of Test---------------------------");
    }

    // 31. Get all the descriptions of all the products
    @Test
    public void testDescriptionsAllProduct() {
        List<String> allDescription = response.extract().path("data.description");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The descriptions of all the products is : " + allDescription);
        System.out.println("------------------End of Test---------------------------");
    }
    // 32. Get id of all the all categories of all the products
    @Test
    public void testIdOfAllCategoriesAllProduct() {
        List<String> allCatagories = response.extract().path("data.categories.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The descriptions of all the products is : " + allCatagories);
        System.out.println("------------------End of Test---------------------------");
    }

    // 33. Find the product names Where type = HardGood
    @Test
    public void test13() {
        List<String> productName = response.extract().path("data.findAll{it.type == 'HardGood'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The descriptions of all the products is : " + productName);
        System.out.println("------------------End of Test---------------------------");
    }

    // 34. Find the Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)
    @Test
    public void test14() {
        List<Objects> numberOfCatategories = response.extract().path("data.findAll{it.name =='Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");
        int totalCategories = numberOfCatategories.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack) is : " + totalCategories);
        System.out.println("------------------End of Test---------------------------");
    }

    // 35. Find the createdAt for all products whose price < 5.49
    @Test
    public void test15() {
        List<String> productName = response.extract().path("data.findAll{it.price < 5.49}.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createdAt for all products whose price < 5.49 is : " + productName);
        System.out.println("------------------End of Test---------------------------");
    }

    // 36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4- Pack)”
    @Test
    public void test16() {
        List<String> productName = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}.categories.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all categories Where product name = “Energizer - MAX Batteries AA (4- Pack)” is : " + productName);
        System.out.println("------------------End of Test---------------------------");
    }

    // 37. Find the manufacturer of all the products
    @Test
    public void test17() {
        List<String> manufacturer = response.extract().path("data.manufacturer");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The manufacturer of all the products is : " + manufacturer);
        System.out.println("------------------End of Test---------------------------");
    }
    // 38. Find the image of products whose manufacturer is = Energizer
    @Test
    public void test18() {
        List<String> image = response.extract().path("data.findAll{it.manufacturer == 'Energizer'}.image");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The image of products whose manufacturer is = Energizer is : " + image);
        System.out.println("------------------End of Test---------------------------");
    }

    // 39. Find the createdAt for all categories products whose price > 5.99
    @Test
    public void test19() {
        List<String> createdAt = response.extract().path("data.findAll{it.price > 5.99}.categories.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createdAt for all products whose price < 5.49 is : " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }

    // 40. Find the uri of all the product
    @Test
    public void test20() {
        List<String> url = response.extract().path("data.url");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The uri of all the product is : " + url);
        System.out.println("------------------End of Test---------------------------");
    }

}
