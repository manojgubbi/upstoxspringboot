package com.manoj.upstox.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Balance
{
    private String message;

    private String timestamp;

    private String status;

    @JsonProperty(value = "data")
    private BalanceData data;

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

    public BalanceData getData ()
    {
        return data;
    }

    public void setData (BalanceData data)
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