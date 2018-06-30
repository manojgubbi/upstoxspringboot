package com.manoj.upstox.utils;

import com.manoj.upstox.data.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class RestTemplateRequestInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        log.info("RestTemplateRequestInterceptor {} {}",CurrentRequestInfoUtils.getAccessToken(),CurrentRequestInfoUtils.getClientKey());
        request.getHeaders().add(Constants.AUTHORIZATION,CurrentRequestInfoUtils.getAccessToken());
        request.getHeaders().add(Constants.X_API_KEEY,CurrentRequestInfoUtils.getClientKey());
        ClientHttpResponse response = execution.execute(request, body);
        return response;
    }
}
