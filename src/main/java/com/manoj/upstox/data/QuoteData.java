package com.manoj.upstox.data;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "lower_circuit",
        "upper_circuit",
        "instrument_name",
        "gn",
        "gd",
        "pn",
        "pd",
        "is_Index",
        "timestamp",
        "circuit_limit",
        "option_type",
        "closing_price",
        "open_interest",
        "is_weekly_contract",
        "tick_size",
        "trading_symbol",
        "vtt",
        "lot_size",
        "prev_open_interest",
        "strike_price",
        "symbol",
        "prev_close",
        "expiry",
        "exchange",
        "token",
        "parent_token"
})
public class QuoteData {

    @JsonProperty("lower_circuit")
    private Float lowerCircuit;
    @JsonProperty("upper_circuit")
    private Float upperCircuit;
    @JsonProperty("instrument_name")
    private String instrumentName;
    @JsonProperty("gn")
    private Integer gn;
    @JsonProperty("gd")
    private Integer gd;
    @JsonProperty("pn")
    private Integer pn;
    @JsonProperty("pd")
    private Integer pd;
    @JsonProperty("is_Index")
    private Boolean isIndex;
    @JsonProperty("timestamp")
    private Long timestamp;
    @JsonProperty("circuit_limit")
    private String circuitLimit;
    @JsonProperty("option_type")
    private String optionType;
    @JsonProperty("closing_price")
    private Float closingPrice;
    @JsonProperty("open_interest")
    private String openInterest;
    @JsonProperty("is_weekly_contract")
    private Boolean isWeeklyContract;
    @JsonProperty("tick_size")
    private Integer tickSize;
    @JsonProperty("trading_symbol")
    private String tradingSymbol;
    @JsonProperty("vtt")
    private Integer vtt;
    @JsonProperty("lot_size")
    private Integer lotSize;
    @JsonProperty("prev_open_interest")
    private Integer prevOpenInterest;
    @JsonProperty("strike_price")
    private Integer strikePrice;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("prev_close")
    private String prevClose;
    @JsonProperty("expiry")
    private Long expiry;
    @JsonProperty("exchange")
    private String exchange;
    @JsonProperty("token")
    private Integer token;
    @JsonProperty("parent_token")
    private Integer parentToken;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("lower_circuit")
    public Float getLowerCircuit() {
        return lowerCircuit;
    }

    @JsonProperty("lower_circuit")
    public void setLowerCircuit(Float lowerCircuit) {
        this.lowerCircuit = lowerCircuit;
    }

    @JsonProperty("upper_circuit")
    public Float getUpperCircuit() {
        return upperCircuit;
    }

    @JsonProperty("upper_circuit")
    public void setUpperCircuit(Float upperCircuit) {
        this.upperCircuit = upperCircuit;
    }

    @JsonProperty("instrument_name")
    public String getInstrumentName() {
        return instrumentName;
    }

    @JsonProperty("instrument_name")
    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    @JsonProperty("gn")
    public Integer getGn() {
        return gn;
    }

    @JsonProperty("gn")
    public void setGn(Integer gn) {
        this.gn = gn;
    }

    @JsonProperty("gd")
    public Integer getGd() {
        return gd;
    }

    @JsonProperty("gd")
    public void setGd(Integer gd) {
        this.gd = gd;
    }

    @JsonProperty("pn")
    public Integer getPn() {
        return pn;
    }

    @JsonProperty("pn")
    public void setPn(Integer pn) {
        this.pn = pn;
    }

    @JsonProperty("pd")
    public Integer getPd() {
        return pd;
    }

    @JsonProperty("pd")
    public void setPd(Integer pd) {
        this.pd = pd;
    }

    @JsonProperty("is_Index")
    public Boolean getIsIndex() {
        return isIndex;
    }

    @JsonProperty("is_Index")
    public void setIsIndex(Boolean isIndex) {
        this.isIndex = isIndex;
    }

    @JsonProperty("timestamp")
    public Long getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("circuit_limit")
    public String getCircuitLimit() {
        return circuitLimit;
    }

    @JsonProperty("circuit_limit")
    public void setCircuitLimit(String circuitLimit) {
        this.circuitLimit = circuitLimit;
    }

    @JsonProperty("option_type")
    public String getOptionType() {
        return optionType;
    }

    @JsonProperty("option_type")
    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    @JsonProperty("closing_price")
    public Float getClosingPrice() {
        return closingPrice;
    }

    @JsonProperty("closing_price")
    public void setClosingPrice(Float closingPrice) {
        this.closingPrice = closingPrice;
    }

    @JsonProperty("open_interest")
    public String getOpenInterest() {
        return openInterest;
    }

    @JsonProperty("open_interest")
    public void setOpenInterest(String openInterest) {
        this.openInterest = openInterest;
    }

    @JsonProperty("is_weekly_contract")
    public Boolean getIsWeeklyContract() {
        return isWeeklyContract;
    }

    @JsonProperty("is_weekly_contract")
    public void setIsWeeklyContract(Boolean isWeeklyContract) {
        this.isWeeklyContract = isWeeklyContract;
    }

    @JsonProperty("tick_size")
    public Integer getTickSize() {
        return tickSize;
    }

    @JsonProperty("tick_size")
    public void setTickSize(Integer tickSize) {
        this.tickSize = tickSize;
    }

    @JsonProperty("trading_symbol")
    public String getTradingSymbol() {
        return tradingSymbol;
    }

    @JsonProperty("trading_symbol")
    public void setTradingSymbol(String tradingSymbol) {
        this.tradingSymbol = tradingSymbol;
    }

    @JsonProperty("vtt")
    public Integer getVtt() {
        return vtt;
    }

    @JsonProperty("vtt")
    public void setVtt(Integer vtt) {
        this.vtt = vtt;
    }

    @JsonProperty("lot_size")
    public Integer getLotSize() {
        return lotSize;
    }

    @JsonProperty("lot_size")
    public void setLotSize(Integer lotSize) {
        this.lotSize = lotSize;
    }

    @JsonProperty("prev_open_interest")
    public Integer getPrevOpenInterest() {
        return prevOpenInterest;
    }

    @JsonProperty("prev_open_interest")
    public void setPrevOpenInterest(Integer prevOpenInterest) {
        this.prevOpenInterest = prevOpenInterest;
    }

    @JsonProperty("strike_price")
    public Integer getStrikePrice() {
        return strikePrice;
    }

    @JsonProperty("strike_price")
    public void setStrikePrice(Integer strikePrice) {
        this.strikePrice = strikePrice;
    }

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @JsonProperty("prev_close")
    public String getPrevClose() {
        return prevClose;
    }

    @JsonProperty("prev_close")
    public void setPrevClose(String prevClose) {
        this.prevClose = prevClose;
    }

    @JsonProperty("expiry")
    public Long getExpiry() {
        return expiry;
    }

    @JsonProperty("expiry")
    public void setExpiry(Long expiry) {
        this.expiry = expiry;
    }

    @JsonProperty("exchange")
    public String getExchange() {
        return exchange;
    }

    @JsonProperty("exchange")
    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    @JsonProperty("token")
    public Integer getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(Integer token) {
        this.token = token;
    }

    @JsonProperty("parent_token")
    public Integer getParentToken() {
        return parentToken;
    }

    @JsonProperty("parent_token")
    public void setParentToken(Integer parentToken) {
        this.parentToken = parentToken;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}


