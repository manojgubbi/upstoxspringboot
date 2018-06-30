package com.manoj.upstox.controller;

import com.manoj.upstox.data.Balance;
import com.manoj.upstox.data.Constants;
import com.manoj.upstox.data.Profile;
import com.manoj.upstox.utils.RequestResponseLoggingInterceptor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;



@Api(value = "BalanceController", description = "BalanceController")
@RequestMapping("/upstox")
@RestController
public class BalanceController {

    private static final String BALANCE_URL = "https://api.upstox.com/live/profile/balance";

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value = "balance")
    @GetMapping("/balance")
    public @ResponseBody Balance getBalance()  {

        URI uri = UriComponentsBuilder.fromUriString(BALANCE_URL)
                .build().toUri();
        ResponseEntity<Balance> balance = restTemplate.exchange(BALANCE_URL, HttpMethod.GET, null, Balance.class);
        System.out.println(balance.getBody());
        return balance.getBody();
    }


}
