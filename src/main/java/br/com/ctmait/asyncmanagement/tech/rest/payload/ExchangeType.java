package br.com.ctmait.asyncmanagement.tech.rest.payload;

import org.springframework.util.Assert;

import java.util.Arrays;

public enum ExchangeType {
    DIRECT("DIRECT"),
    FANOUT("FANOUT"),
    TOPIC("TOPIC");

    private String code;

    ExchangeType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public ExchangeType getByCode(String code){
        Assert.notNull(code, "code cannot null");
        return Arrays.stream(values())
                .filter(exchangeType -> exchangeType.code.equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("code is not a value valid"));
    }

    @Override
    public String toString() {
        return "ExchangeType{" +
                "code='" + code + '\'' +
                '}';
    }
}
