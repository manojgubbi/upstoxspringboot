package com.manoj.upstox.controller;

import com.manoj.upstox.data.Profile;
import com.manoj.upstox.data.Quote;
import com.manoj.upstox.data.QuoteData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@Api(value = "QuotesController", description = "QuotesController")

@RequestMapping("/upstox")
public class QuotesController {

    private static final String URL = "https://api.upstox.com/index/master-contract/nse_fo";

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value = "Quotes")
    @GetMapping("/quotes")
    public @ResponseBody
    Quote getQuotes(@RequestParam(value = "symbol") String symbol){
        URI targetUri = UriComponentsBuilder.fromUriString(URL)
                .queryParam("symbol",symbol).build()
                .toUri();
        ResponseEntity<Quote> quote = restTemplate.exchange(targetUri,HttpMethod.GET,null,Quote.class);
        return quote.getBody();
    }


}
