package com.mowitnow.boot.rest.resoures;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by asagaama on 13/11/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MowerControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;
    //Required to Generate JSON content from Java objects
    public static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Test the POST /v1/mower API
     */
    @Test
    public void testProcess() throws JsonProcessingException {
        Map<String, Object> requestBody = new HashMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(requestBody), headers);

        ResponseEntity<Map> responseE = restTemplate.exchange("/v1/mower", HttpMethod.POST, entity, Map.class, Collections.EMPTY_MAP);

        assertNotNull(responseE);
    }
}
