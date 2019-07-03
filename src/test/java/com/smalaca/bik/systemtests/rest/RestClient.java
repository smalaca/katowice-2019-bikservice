package com.smalaca.bik.systemtests.rest;

import org.springframework.web.client.RestTemplate;

public class RestClient {
    private final RestTemplate restTemplate;
    private final String bikServiceUrl;

    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        bikServiceUrl = "http://localhost:8002";
    }


    public String checkHistory(String pesel) {
        String url = bikServiceUrl + "/history/" + pesel;
        return restTemplate.getForEntity(url, String.class).getBody();
    }
}