package com.hrms.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

//given()
//when()
//then()
public class apiHardCodedExamples {

    String baseURI=RestAssured.baseURI = "http://3.237.189.167/syntaxapi/api";
    static String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MTQxMjgwNTEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYxNDE3MTI1MSwidXNlcklkIjoiMjQyMyJ9.JoLUB6ImFnGnLFDvs0iTLp86XneOpsF7PUEOZusG6lc";
    @Test
    public void sampleTest() {

         //presparing request to get one employee
        RequestSpecification preparingGetOneEmployeeRequest = given().header("Authorization", token)
                .header("Content-Type", "Application/json")
                .queryParam("employee_id", "13001");
        //sending the request to the endpoint
        Response getOneEmployeeResponse = preparingGetOneEmployeeRequest.when().get("/getOneEmployee.php");
        //print the response
        System.out.println(getOneEmployeeResponse.asString());
    }

    @Test
    public void ePostCreateEmployee(){
        //preparing to create an employee request
       RequestSpecification createEmployeeRequest= given().header("Authorization", token)
                .header("Content-Type", "Application/json")
                .body("{\n" +
                        "  \"emp_firstname\": \"Elias\",\n" +
                        "  \"emp_lastname\": \"Alvial\",\n" +
                        "  \"emp_middle_name\": null,\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2021-02-11\",\n" +
                        "  \"emp_status\": \"employee\",\n" +
                        "  \"emp_job_title\": \"IT Analyst\"\n" +
                        "}");

       //this method is creating the post call to create the employee. it matches with Postman
        Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");
        //Printing the Employee ID
        createEmployeeResponse.prettyPrint();
        //Assert that status code is 201
        createEmployeeResponse.then().assertThat().statusCode(201);
        //Get Employee_id
        String employeeID=createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
        //Print Employee_id
        System.out.println(employeeID);

        //Assert that message contains Entry Created
        createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));

        //Assert that employee is id 15855A
        createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("Elias"));


    }

    @Test
    public void bGetCreatedEmployee(){
        RequestSpecification getCreatedEmployee= given().header("Authorization", token)
                .header("Content-Type", "Application/json").queryParam("employee_id","15855A" );
        Response getEmployeeResponse=getCreatedEmployee.when().get("/getOneEmployee.php");

        String empID=getEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
        boolean verifyEmployeeId=empID.equalsIgnoreCase("15855A");
        System.out.println(verifyEmployeeId);
    }

}
