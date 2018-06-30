package com.manoj.upstox.controller;


import com.manoj.upstox.data.Constants;
import com.manoj.upstox.data.Position;
import com.manoj.upstox.data.PositionData;
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
import java.util.List;

@RestController
@RequestMapping("/upstox")
@Api(value = "PositionController", description = "PositionController")

public class PositionController {

    private static final String POSITION_URL = "https://api.upstox.com/live/profile/positions";

    @Autowired
    private RestTemplate restTemplate;


    @ApiOperation(value = "position")
    @GetMapping("/position")
    public @ResponseBody
    PositionData[] getPositions() {
        URI uri = UriComponentsBuilder.fromUriString(POSITION_URL)
                .build().toUri();
        ResponseEntity<Position> position = restTemplate.exchange(uri, HttpMethod.GET, null, Position.class);
        System.out.println(position.getBody().getData());
        return position.getBody().getData();


    }


}
