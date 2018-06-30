package com.manoj.upstox.controller;


import com.manoj.upstox.data.Constants;
import com.manoj.upstox.data.Profile;
import com.manoj.upstox.utils.RequestResponseLoggingInterceptor;
import com.manoj.upstox.utils.RestTemplateRequestInterceptor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;


@Api(value = "ProfileController", description = "ProfileController")
@RequestMapping("/upstox")
@RestController
public class ProfileController {

    private static final String PROFILE_URL = "https://api.upstox.com/index/profile";

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value = "profile")
    @GetMapping("/profile")
    public @ResponseBody  Profile getProfile(){
        URI uri = UriComponentsBuilder.fromUriString(PROFILE_URL)
                .build().toUri();
        ResponseEntity<Profile> profile = restTemplate.exchange(PROFILE_URL,HttpMethod.GET,null,Profile.class);
        System.out.println(profile.getBody());
        return profile.getBody();



    }
}
