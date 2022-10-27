package br.com.ctmait.asyncmanagement.domain.rabbit;

import java.util.Objects;

public class Binding {

    private Exchange exchange;
    private Queue queue;

    public Binding() {
    }

    public Binding(Exchange exchange, Queue queue) {
        this.exchange = exchange;
        this.queue = queue;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Binding)) return false;
        Binding binding = (Binding) o;
        return Objects.equals(getExchange(), binding.getExchange()) && Objects.equals(getQueue(), binding.getQueue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExchange(), getQueue());
    }

    @Override
    public String toString() {
        return "Binding{" +
                "exchange=" + exchange +
                ", queue=" + queue +
                '}';
    }
}
