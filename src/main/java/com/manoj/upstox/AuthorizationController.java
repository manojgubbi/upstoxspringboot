package com.manoj.upstox;


import com.manoj.upstox.com.manoj.upstox.data.Authorization;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthorizationController {


    @Value("${apikey}")
    private String userName;
    @Value("${apisecret}")
    private String password;
    @Value("${accessTokenUrl}")
    private String accessTokenUrl;
    private static final String CODE_QUERYPARAM = "code";
    private static final String REDIRECT_URI_QUERYPARAM = "redirect_uri";
    private static final String GRANT_TYPE_QUERYPARAM = "grant_type ";
    private static final String API_KEY_HEADER = "x-api-key";



    @RequestMapping("/")
    public String getAccessToken(@RequestParam("code") String code){
        System.out.println("api key is ");
        RestTemplate restTemplate = new RestTemplate();
       // restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(userName, password));
//        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
//        messageConverters.add(new FormHttpMessageConverter());
//        messageConverters.add(new StringHttpMessageConverter());
//        restTemplate.setMessageConverters(messageConverters);

        String plainString = userName+":"+password;
        System.out.println("api key is "+plainString);
        String base64ClientCredentials = new String(Base64.encodeBase64(plainString.getBytes()));

        HttpHeaders headers = new HttpHeaders();
       // headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Basic " + base64ClientCredentials);
        headers.setContentType(MediaType.APPLICATION_JSON   );
        headers.add("x-api-key", userName);
        Authorization authorization = new Authorization();
        authorization.setCode(code);
        authorization.setGrantType("authorization_code");
        authorization.setRedirectUri("http://127.0.0.1:8080");
        URI uri = UriComponentsBuilder.fromUriString(accessTokenUrl)
                .build().toUri();
        System.out.println(uri.toString());
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add(CODE_QUERYPARAM, code);
        map.add(GRANT_TYPE_QUERYPARAM, "authorization_code");
        map.add(REDIRECT_URI_QUERYPARAM, "http://127.0.0.1:8080");

        HttpEntity<Authorization> request = new HttpEntity<>(authorization, headers);

      //  HttpEntity<Authorization> httpEntity = new HttpEntity<>(authorization,headers);
        try {
          //  String response = restTemplate.postForObject(uri    , request, String.class);
            ResponseEntity<String> model = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);

            return model.getBody();
        }catch(HttpClientErrorException httpException){
            return httpException.getResponseBodyAsString();
        }

    }
}
