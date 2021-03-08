package com.shop.mypetshop.rest;

import com.shop.mypetshop.rest.dto.PetDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PetsTest
{
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void test_getAll()
    {
        final ResponseEntity<PetDto[]> response = restTemplate.getForEntity(createBaseUrl() + "/pets", PetDto[].class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        final List<PetDto> responsePets = Arrays.asList(response.getBody());
        assertEquals(11, responsePets.size());
        responsePets.forEach(entity -> {
            assertNotNull(entity.getId());
            assertNotNull(entity.getName());
            assertNotNull(entity.getBreed());
            assertNotNull(entity.getSpecie());
        });
    }

    private String createBaseUrl()
    {
        return String.format("http://localhost:%s", port);
    }
}
