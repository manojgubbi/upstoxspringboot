package com.manoj.upstox.com.manoj.upstox.data;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Authorization {

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    @JsonProperty("grant_type")

    private String grantType;


    @JsonProperty("code")
    private String code;


    @JsonProperty("redirect_uri")
    private String redirectUri;

}
