package com.manoj.upstox.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true) //must be there all times most likely
public class Data implements Serializable
{
    @JsonProperty //this annotation is also necessary
    private String phone;
    @JsonProperty //this annotation is also necessary
    private String email;
    @JsonProperty //this annotation is also necessary
    private String[] exchanges_enabled;
    @JsonProperty //this annotation is also necessary
    private String name;
    @JsonProperty //this annotation is also necessary
    private String client_id;

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBank_account() {
        return bank_account;
    }

    public void setBank_account(String bank_account) {
        this.bank_account = bank_account;
    }

    @JsonProperty //this annotation is also necessary

    private String[] products_enabled;
    @JsonProperty //this annotation is also necessary
    private String bank_name;
    @JsonProperty //this annotation is also necessary
    private String bank_account;
    public String getPhone ()
    {
        return phone;
    }

    public void setPhone (String phone)
    {
        this.phone = phone;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String[] getExchanges_enabled ()
    {
        return exchanges_enabled;
    }

    public void setExchanges_enabled (String[] exchanges_enabled)
    {
        this.exchanges_enabled = exchanges_enabled;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getClient_id ()
    {
        return client_id;
    }

    public void setClient_id (String client_id)
    {
        this.client_id = client_id;
    }

    public String[] getProducts_enabled ()
    {
        return products_enabled;
    }

    public void setProducts_enabled (String[] products_enabled)
    {
        this.products_enabled = products_enabled;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [phone = "+phone+", email = "+email+", exchanges_enabled = "+exchanges_enabled+", name = "+name+", client_id = "+client_id+", products_enabled = "+products_enabled+"]";
    }
}