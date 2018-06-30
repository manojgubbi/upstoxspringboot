package com.manoj.upstox.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@JsonIgnoreProperties(ignoreUnknown = true) //must be there all times most likely
public class Profile implements Serializable
{
    @JsonProperty //this annotation is also necessary
    private String message;
    @JsonProperty //this annotation is also necessary
    private String timestamp;
    @JsonProperty //this annotation is also necessary
    private String status;
    @JsonProperty //this annotation is also necessary
    private Data data;
    @JsonProperty //this annotation is also necessary
    private String code;

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public String getTimestamp ()
    {
        return timestamp;
    }

    public void setTimestamp (String timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public Data getData ()
    {
        return data;
    }

    public void setData (Data data)
    {
        this.data = data;
    }

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message = "+message+", timestamp = "+timestamp+", status = "+status+", data = "+data+", code = "+code+"]";
    }
}

