package com.example.nasatelegrambotspring.service.impl;

import com.example.nasatelegrambotspring.model.NasaObject;
import com.example.nasatelegrambotspring.service.NasaService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class DefaultNasaService implements NasaService {

    private final static RestTemplate restTemplate = new RestTemplate();
    private final static String URL = "https://api.nasa.gov/planetary/apod?api_key=";
    private static final String TOKEN = "Ve1JQZ2suNOoDzkWIqkTjMnXafv1WFphwxnS6jD7";


    @Override
    public NasaObject getPhotoOrVideo() {
        String requestURL = URL + TOKEN;

        return restTemplate.getForEntity(requestURL, NasaObject.class).getBody();
    }

}
