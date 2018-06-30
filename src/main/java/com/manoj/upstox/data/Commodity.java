package com.manoj.upstox.data;

public class Commodity
{
    private String available_margin;

    private String payin_amount;

    private String used_margin;

    private String notional_cash;

    private String adhoc_margin;

    private String exposure_margin;

    private String span_margin;

    public String getAvailable_margin ()
    {
        return available_margin;
    }

    public void setAvailable_margin (String available_margin)
    {
        this.available_margin = available_margin;
    }

    public String getPayin_amount ()
    {
        return payin_amount;
    }

    public void setPayin_amount (String payin_amount)
    {
        this.payin_amount = payin_amount;
    }

    public String getUsed_margin ()
    {
        return used_margin;
    }

    public void setUsed_margin (String used_margin)
    {
        this.used_margin = used_margin;
    }

    public String getNotional_cash ()
    {
        return notional_cash;
    }

    public void setNotional_cash (String notional_cash)
    {
        this.notional_cash = notional_cash;
    }

    public String getAdhoc_margin ()
    {
        return adhoc_margin;
    }

    public void setAdhoc_margin (String adhoc_margin)
    {
        this.adhoc_margin = adhoc_margin;
    }

    public String getExposure_margin ()
    {
        return exposure_margin;
    }

    public void setExposure_margin (String exposure_margin)
    {
        this.exposure_margin = exposure_margin;
    }

    public String getSpan_margin ()
    {
        return span_margin;
    }

    public void setSpan_margin (String span_margin)
    {
        this.span_margin = span_margin;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [available_margin = "+available_margin+", payin_amount = "+payin_amount+", used_margin = "+used_margin+", notional_cash = "+notional_cash+", adhoc_margin = "+adhoc_margin+", exposure_margin = "+exposure_margin+", span_margin = "+span_margin+"]";
    }
}