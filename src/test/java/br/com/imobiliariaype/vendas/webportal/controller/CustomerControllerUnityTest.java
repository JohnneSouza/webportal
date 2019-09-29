package br.com.imobiliariaype.vendas.webportal.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@WebFluxTest
public class CustomerControllerUnityTest {

    private static final String CUSTOMER_URL = "/v1/customers";

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void getAllClientsTest() {

        webTestClient.get().uri(CUSTOMER_URL)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

}
