package com.accenture.testeaccenturefullstackbackend.service;

import com.accenture.testeaccenturefullstackbackend.model.Cep;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CepService {

    private static String MAIN_URL = "http://cep.la/";

    public static Cep getCepInfo(String cep){
        RestTemplate rt = new RestTemplate();

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        messageConverters.add(converter);
        rt.setMessageConverters(messageConverters);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        try {
            ResponseEntity<Cep> response = rt.exchange(
                MAIN_URL + cep, HttpMethod.GET, requestEntity, Cep.class);

            return response.getBody();
        } catch (RestClientException ex) {
            return null;
        }

    }

}
