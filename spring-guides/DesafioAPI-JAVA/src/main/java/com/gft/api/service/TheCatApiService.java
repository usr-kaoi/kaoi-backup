package com.gft.api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TheCatApiService {

    @Value("${thecatapi.apikey}")
    private String apikey;

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String THE_CAT_API_URL = "https://api.thecatapi.com/v1";

    public String buscarRacas() {
        String url = THE_CAT_API_URL + "/breeds";
        return restTemplate.getForObject(url, String.class);
    }

    public String buscarImagensPorRaca(String racaId) {
        String url = THE_CAT_API_URL + "/images/search?breed_ids=" + racaId;
        return restTemplate.getForObject(url, String.class);
    }
}
