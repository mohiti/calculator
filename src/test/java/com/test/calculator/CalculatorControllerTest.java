package com.test.calculator;

import com.test.calculator.model.CalculateResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorControllerTest {



    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testAdd() throws Exception {

        CalculateResult result = restTemplate.getForObject(createURLWithPort( "/add?number1=240&number2=361"),CalculateResult.class);
        assertEquals(BigDecimal.valueOf(601), result.getOperationResult());

    }

    @Test
    public void testSubtract() throws Exception {
        CalculateResult result = restTemplate.getForObject(createURLWithPort( "/subtract?number1=20.93&number2=43.84"),CalculateResult.class);
        assertEquals(BigDecimal.valueOf(-22.91), result.getOperationResult());
    }

    @Test
    public void testDivide() throws Exception {
        CalculateResult result = restTemplate.getForObject(createURLWithPort( "/divide?number1=245&number2=784"),CalculateResult.class);
        assertEquals(BigDecimal.valueOf(0.3125), result.getOperationResult());
    }

    @Test
    public void testMultiply() throws Exception {
        CalculateResult result = restTemplate.getForObject(createURLWithPort( "/multiply?number1=77.77&number2=55.26"),CalculateResult.class);
        assertEquals(BigDecimal.valueOf(4297.5702), result.getOperationResult());
    }

    @Test
    public void testSquare() throws Exception {
        CalculateResult result = restTemplate.getForObject(createURLWithPort( "/square?number1=55.45"),CalculateResult.class);
        assertEquals(BigDecimal.valueOf(3074.7025), result.getOperationResult());
    }

    @Test
    public void testFactorial() throws Exception {
        CalculateResult result = restTemplate.getForObject(createURLWithPort( "/factorial?number1=20"),CalculateResult.class);
        assertEquals(new BigDecimal("2432902008176640000"), result.getOperationResult());
    }


    // add operation test

    @Test
    public void testValidateAddByZero() {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<?> response = restTemplate.exchange(

                createURLWithPort("/add?number1=10&number2=0"), HttpMethod.GET, entity, String.class);


        int actual1 = response.getStatusCode().value();

        assertEquals(200,actual1);


    }

    @Test
    public void testValidateAddByString() {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<?> response = restTemplate.exchange(

                createURLWithPort("/add?number1=errordsasa&number2=0"), HttpMethod.GET, entity, String.class);


        int actual1 = response.getStatusCode().value();

        assertEquals(400,actual1);
    }

    @Test
    public void testValidateAddByEmpty() {


        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<?> response = restTemplate.exchange(

                createURLWithPort("/add?number1=&number2=45"), HttpMethod.GET, entity, String.class);


        int actual1 = response.getStatusCode().value();

        assertEquals(400,actual1);
    }


    // divide operation test

    @Test
    public void testValidateDivideByZero() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<?> response = restTemplate.exchange(

                createURLWithPort("/divide?number1=45&number2=0"), HttpMethod.GET, entity, String.class);


        int actual1 = response.getStatusCode().value();

        assertEquals(400,actual1);
    }

    @Test
    public void testValidateDivideByString() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<?> response = restTemplate.exchange(

                createURLWithPort("/divide?number1=errordsasa&number2=0"), HttpMethod.GET, entity, String.class);


        int actual1 = response.getStatusCode().value();

        assertEquals(400,actual1);
    }

    @Test
    public void testValidateDivideByEmpty() {


        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<?> response = restTemplate.exchange(

                createURLWithPort("/divide?number1=&number2=45"), HttpMethod.GET, entity, String.class);


        int actual1 = response.getStatusCode().value();

        assertEquals(400,actual1);
    }


    // multiply operation test


    @Test
    public void testValidateMultiplyByZero() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<?> response = restTemplate.exchange(

                createURLWithPort("/multiply?number1=45&number2=0"), HttpMethod.GET, entity, String.class);


        int actual1 = response.getStatusCode().value();

        assertEquals(200,actual1);
    }

    @Test
    public void testValidateMultiplyByString() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<?> response = restTemplate.exchange(

                createURLWithPort("/multiply?number1=errordsasa&number2=0"), HttpMethod.GET, entity, String.class);


        int actual1 = response.getStatusCode().value();

        assertEquals(400,actual1);
    }

    @Test
    public void testValidateMultiplyByEmpty() {


        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<?> response = restTemplate.exchange(

                createURLWithPort("/multiply?number1=&number2=45"), HttpMethod.GET, entity, String.class);


        int actual1 = response.getStatusCode().value();

        assertEquals(400,actual1);
    }



    // subtract operation test


    @Test
    public void testValidateSubtractByZero() {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<?> response = restTemplate.exchange(

                createURLWithPort("/subtract?number1=10&number2=0"), HttpMethod.GET, entity, String.class);


        int actual1 = response.getStatusCode().value();

        assertEquals(200,actual1);


    }

    @Test
    public void testValidateSubtractByString() {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<?> response = restTemplate.exchange(

                createURLWithPort("/subtract?number1=errordsasa&number2=0"), HttpMethod.GET, entity, String.class);


        int actual1 = response.getStatusCode().value();

        assertEquals(400,actual1);
    }

    @Test
    public void testValidateSubtractByEmpty() {


        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<?> response = restTemplate.exchange(

                createURLWithPort("/subtract?number1=&number2=45"), HttpMethod.GET, entity, String.class);


        int actual1 = response.getStatusCode().value();

        assertEquals(400,actual1);
    }



    private String createURLWithPort(String uri) {

        //System.out.println("http://localhost:" + port + uri);
        return "http://localhost:" + port +"/api/v1"+ uri;

    }




}
