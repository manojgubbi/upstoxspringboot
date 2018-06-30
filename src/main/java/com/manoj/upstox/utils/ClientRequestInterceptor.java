package com.manoj.upstox.utils;
import com.manoj.upstox.data.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
public class ClientRequestInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //Disable interceptor check for CORS pre flight request
        if (request.getMethod().equals(HttpMethod.OPTIONS.toString())) {
            return true;
        }
        log.info("came to ClientRequestInterceptor");
        String accessToken = request.getHeader(Constants.AUTHORIZATION);
        String apiKey = request.getHeader(Constants.X_API_KEEY);
        log.info("came to ClientRequestInterceptor {} {}" ,accessToken,apiKey);
        CurrentRequestInfoUtils.setAttributes(Constants.AUTHORIZATION, accessToken);
        CurrentRequestInfoUtils.setAttributes(Constants.X_API_KEEY, apiKey);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Set<String> attributeSet = new HashSet<>();
        attributeSet.add(Constants.AUTHORIZATION);
        attributeSet.add(Constants.X_API_KEEY);
        CurrentRequestInfoUtils.removeAttributes(attributeSet);
    }
}

