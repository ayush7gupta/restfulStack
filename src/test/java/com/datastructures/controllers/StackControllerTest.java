package com.datastructures.controllers;

import com.datastructures.models.InputCriteria;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StackControllerTest {
    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testcreateDataStructureSuccess()throws Exception{
        int i = 2;
        headers.setContentType(MediaType.APPLICATION_JSON);

        InputCriteria inputCriteria = new InputCriteria();
        inputCriteria.setNum(String.valueOf(i));
        HttpEntity<String> entity = new HttpEntity<String>(objectMapper.writeValueAsString(inputCriteria), headers);
        ResponseEntity<?> response = restTemplate.exchange(
                createURLWithPort("/stack/create"), HttpMethod.POST, entity, String.class);

        String expected = "{\"response\":\"Created stack of size: 2\",\"stack\":[]}";
        assertEquals(response.getBody().toString(), expected);
    }

    @Test
    public void testcreateDataStructureFail()throws Exception{
        int i = 0;
        headers.setContentType(MediaType.APPLICATION_JSON);

        InputCriteria inputCriteria = new InputCriteria();
        inputCriteria.setNum(String.valueOf(i));
        HttpEntity<String> entity = new HttpEntity<String>(objectMapper.writeValueAsString(inputCriteria), headers);
        ResponseEntity<?> response = restTemplate.exchange(
                createURLWithPort("/stack/create"), HttpMethod.POST, entity, String.class);

        String expected = "{\"response\":\"Size of stack cannot be <=0\",\"stack\":null}";
        assertEquals(response.getBody().toString(), expected);
    }

    @Test
    public void testPushFailNotInitiated() throws Exception{
        int i = 0;
        headers.setContentType(MediaType.APPLICATION_JSON);

        InputCriteria inputCriteria = new InputCriteria();
        inputCriteria.setNum(String.valueOf(i));
        HttpEntity<String> entity = new HttpEntity<String>(objectMapper.writeValueAsString(inputCriteria), headers);
        ResponseEntity<?> response = restTemplate.exchange(
                createURLWithPort("/stack/push"), HttpMethod.POST, entity, String.class);

        String expected = "{\"response\":\"Stack is not initiated.\",\"stack\":null}";
        assertEquals(response.getBody().toString(), expected);
    }

    @Test
    public void testPushFailFullStack() throws Exception{
        int i = 2;
        headers.setContentType(MediaType.APPLICATION_JSON);

        InputCriteria inputCriteria = new InputCriteria();
        inputCriteria.setNum(String.valueOf(i));
        HttpEntity<String> entity = new HttpEntity<String>(objectMapper.writeValueAsString(inputCriteria), headers);

        restTemplate.exchange(createURLWithPort("/stack/create"), HttpMethod.POST, entity, String.class);

        restTemplate.exchange(
                createURLWithPort("/stack/push"), HttpMethod.POST, entity, String.class);

        restTemplate.exchange(
                createURLWithPort("/stack/push"), HttpMethod.POST, entity, String.class);
        ResponseEntity<?> response = restTemplate.exchange(
                createURLWithPort("/stack/push"), HttpMethod.POST, entity, String.class);

        String expected = "{\"response\":\"Stack is full. Cannot insert element.\",\"stack\":[2,2]}";
        assertEquals(response.getBody().toString(), expected);
    }

    @Test
    public void testPushSuccess() throws Exception{
        int i = 2;
        headers.setContentType(MediaType.APPLICATION_JSON);

        InputCriteria inputCriteria = new InputCriteria();
        inputCriteria.setNum(String.valueOf(i));
        HttpEntity<String> entity = new HttpEntity<String>(objectMapper.writeValueAsString(inputCriteria), headers);

        restTemplate.exchange(createURLWithPort("/stack/create"), HttpMethod.POST, entity, String.class);

        restTemplate.exchange(createURLWithPort("/stack/push"), HttpMethod.POST, entity, String.class);
        ResponseEntity<?> response = restTemplate.exchange(
                createURLWithPort("/stack/push"), HttpMethod.POST, entity, String.class);

        String expected = "{\"response\":\"Element added to the stack: 2\",\"stack\":[2,2]}";
        assertEquals(response.getBody().toString(), expected);
    }

    @Test
    public void testPopFailNotInitiated() {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<?> response = restTemplate.exchange(
                createURLWithPort("/stack/pop"), HttpMethod.DELETE, entity, String.class);

        String expected = "{\"response\":\"Stack is not initiated.\",\"stack\":null}";
        assertEquals(response.getBody().toString(), expected);
    }

    @Test
    public void testPopFailEmpty() throws Exception{
        int i = 2;
        headers.setContentType(MediaType.APPLICATION_JSON);

        InputCriteria inputCriteria = new InputCriteria();
        inputCriteria.setNum(String.valueOf(i));
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<String> entity = new HttpEntity<String>(objectMapper.writeValueAsString(inputCriteria), headers);

        restTemplate.exchange(createURLWithPort("/stack/create"), HttpMethod.POST, entity, String.class);
        ResponseEntity<?> response = restTemplate.exchange(
                createURLWithPort("/stack/pop"), HttpMethod.DELETE, entity, String.class);

        String expected = "{\"response\":\"Stack is empty.\",\"stack\":[]}";
        assertEquals(response.getBody().toString(), expected);
    }

    @Test
    public void testPopSuccess()throws Exception{
        int i = 2;
        headers.setContentType(MediaType.APPLICATION_JSON);

        InputCriteria inputCriteria = new InputCriteria();
        inputCriteria.setNum(String.valueOf(i));
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<String> entity = new HttpEntity<String>(objectMapper.writeValueAsString(inputCriteria), headers);
        restTemplate.exchange(createURLWithPort("/stack/create"), HttpMethod.POST, entity, String.class);
        restTemplate.exchange(createURLWithPort("/stack/push"), HttpMethod.POST, entity, String.class);
        ResponseEntity<?> response = restTemplate.exchange(
                createURLWithPort("/stack/pop"), HttpMethod.DELETE, entity, String.class);

        String expected = "{\"response\":\"The popped element is: 2\",\"stack\":[]}";
        assertEquals(response.getBody().toString(), expected);
    }


    @Test
    public void testPeekFail(){
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<?> response = restTemplate.exchange(
                createURLWithPort("/stack/peek"), HttpMethod.GET, entity, String.class);
        String expected = "{\"response\":\"Stack is not initiated.\",\"stack\":null}";

        assertEquals(response.getBody().toString(), expected);
    }

    @Test
    public void testPeekFailEmptyStack()throws Exception{
        int i = 2;
        headers.setContentType(MediaType.APPLICATION_JSON);

        InputCriteria inputCriteria = new InputCriteria();
        inputCriteria.setNum(String.valueOf(i));
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<String> entity = new HttpEntity<String>(objectMapper.writeValueAsString(inputCriteria), headers);

        restTemplate.exchange(createURLWithPort("/stack/create"), HttpMethod.POST, entity, String.class);
        ResponseEntity<?> response = restTemplate.exchange(
                createURLWithPort("/stack/peek"), HttpMethod.GET, entity, String.class);

        String expected = "{\"response\":\"Stack is empty.\",\"stack\":[]}";
        assertEquals(response.getBody().toString(), expected);
    }

    @Test
    public void testPeekSuccess() throws Exception{
        int i = 2;
        headers.setContentType(MediaType.APPLICATION_JSON);

        InputCriteria inputCriteria = new InputCriteria();
        inputCriteria.setNum(String.valueOf(i));
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<String> entity = new HttpEntity<String>(objectMapper.writeValueAsString(inputCriteria), headers);
        restTemplate.exchange(createURLWithPort("/stack/create"), HttpMethod.POST, entity, String.class);
        restTemplate.exchange(createURLWithPort("/stack/push"), HttpMethod.POST, entity, String.class);
        ResponseEntity<?> response = restTemplate.exchange(
                createURLWithPort("/stack/peek"), HttpMethod.GET, entity, String.class);

        String expected = "{\"response\":\"The top most element is: 2\",\"stack\":[2]}";
        assertEquals(response.getBody().toString(), expected);
    }

    @Test
    public void testResetFail(){
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<?> response = restTemplate.exchange(
                createURLWithPort("/stack/reset"), HttpMethod.GET, entity, String.class);
        String expected = "{\"response\":\"Stack is not initiated.\",\"stack\":null}";

        assertEquals(response.getBody().toString(), expected);
    }

    @Test
    public void testResetSuccess() throws Exception{
        int i = 2;
        headers.setContentType(MediaType.APPLICATION_JSON);

        InputCriteria inputCriteria = new InputCriteria();
        inputCriteria.setNum(String.valueOf(i));
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<String> entity = new HttpEntity<String>(objectMapper.writeValueAsString(inputCriteria), headers);
        restTemplate.exchange(createURLWithPort("/stack/create"), HttpMethod.POST, entity, String.class);
        restTemplate.exchange(createURLWithPort("/stack/push"), HttpMethod.POST, entity, String.class);
        ResponseEntity<?> response = restTemplate.exchange(
                createURLWithPort("/stack/reset"), HttpMethod.GET, entity, String.class);

        String expected = "{\"response\":\"Stack reset\",\"stack\":[]}";
        assertEquals(response.getBody().toString(), expected);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
