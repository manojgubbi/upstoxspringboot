package com.manoj.upstox.utils;

import com.manoj.upstox.data.Constants;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Set;


public class CurrentRequestInfoUtils {

    private CurrentRequestInfoUtils() {}

    public static void setAttributes(String name, Object value) {
        if (StringUtils.isEmpty(name) || value == null) {
            return;
        }

        try {
            RequestAttributes reqAttr = RequestContextHolder.currentRequestAttributes();
            reqAttr.setAttribute(name, value, RequestAttributes.SCOPE_REQUEST);
            RequestContextHolder.setRequestAttributes(reqAttr, true);
        } catch (IllegalStateException e) {
        }
    }

    public static <T> T getAttributes(String name, Class<T> clazz) {
        Object value = null;

        try {
            value = RequestContextHolder.currentRequestAttributes().getAttribute(name, RequestAttributes.SCOPE_REQUEST);
        } catch (IllegalStateException e) {
        }

        T result = null;
        if (value != null) {
            result = clazz.cast(value);
        }


        return result;
    }

    public static void removeAttributes(Set<String> attributeSet) {

        try {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            for (String attribute : attributeSet) {
                requestAttributes.removeAttribute(attribute, RequestAttributes.SCOPE_REQUEST);
            }
        } catch (IllegalStateException e) {
        }


    }

    public static String getAccessToken() {
        return getAttributes(Constants.AUTHORIZATION, String.class);
    }

    public static String getClientKey() {
        return getAttributes(Constants.X_API_KEEY, String.class);
    }


    }



