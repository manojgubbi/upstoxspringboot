package com.manoj.upstox.controller;


import com.manoj.upstox.data.AccessToken;
import com.manoj.upstox.data.Authorization;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
@Api(value = "Authcontroller", description = "AuthorizationController")
@RestController
@RequestMapping("/upstox")
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



    @ApiOperation(value = "authorization")
    @GetMapping("/auth")
    public String getAccessToken(@RequestParam("code") String code){
        System.out.println("api key is ");
        RestTemplate restTemplate = new RestTemplate();
        String plainString = userName+":"+password;
        System.out.println("api key is "+plainString);
        String base64ClientCredentials = new String(Base64.encodeBase64(plainString.getBytes()));
        HttpHeaders headers = new HttpHeaders();
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
        try {
            ResponseEntity<AccessToken> model = restTemplate.exchange(uri, HttpMethod.POST, request, AccessToken.class);
            return model.getBody().toString();
        }catch(HttpClientErrorException httpException){
            return httpException.getResponseBodyAsString();
        }

    }
}
