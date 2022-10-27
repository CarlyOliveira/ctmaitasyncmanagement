package br.com.ctmait.asyncmanagement.domain.rabbit;


import java.util.Objects;

public class Exchange {

    private ExchangeType exchangeType;
    private String name;

    public Exchange() {
    }

    public Exchange(ExchangeType exchangeType, String name) {
        this.exchangeType = exchangeType;
        this.name = name;
    }

    public ExchangeType getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(ExchangeType exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exchange)) return false;
        Exchange exchange = (Exchange) o;
        return getExchangeType() == exchange.getExchangeType() && Objects.equals(getName(), exchange.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExchangeType(), getName());
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "exchangeType=" + exchangeType +
                ", name='" + name + '\'' +
                '}';
    }
}
