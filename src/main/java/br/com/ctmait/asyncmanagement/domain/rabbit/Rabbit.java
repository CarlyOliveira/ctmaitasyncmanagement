package br.com.ctmait.asyncmanagement.domain.rabbit;

import java.util.Objects;
import java.util.function.Consumer;

public class Rabbit {
    private String id;
    private Exchange exchange;
    private Queue queue;
    private Exchange exchangeDlq;
    private Queue queueDlq;

    public Rabbit() {
    }

    public Rabbit(String id, Exchange exchange, Queue queue, Exchange exchangeDlq, Queue queueDlq) {
        this.id = id;
        this.exchange = exchange;
        this.queue = queue;
        this.exchangeDlq = exchangeDlq;
        this.queueDlq = queueDlq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Exchange getExchangeDlq() {
        return exchangeDlq;
    }

    public void setExchangeDlq(Exchange exchangeDlq) {
        this.exchangeDlq = exchangeDlq;
    }

    public Queue getQueueDlq() {
        return queueDlq;
    }

    public void setQueueDlq(Queue queueDlq) {
        this.queueDlq = queueDlq;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rabbit)) return false;
        Rabbit rabbit = (Rabbit) o;
        return Objects.equals(getId(), rabbit.getId()) && Objects.equals(getExchange(), rabbit.getExchange()) && Objects.equals(getQueue(), rabbit.getQueue()) && Objects.equals(getExchangeDlq(), rabbit.getExchangeDlq()) && Objects.equals(getQueueDlq(), rabbit.getQueueDlq());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getExchange(), getQueue(), getExchangeDlq(), getQueueDlq());
    }

    @Override
    public String toString() {
        return "Rabbit{" +
                "id='" + id + '\'' +
                ", exchange=" + exchange +
                ", queue=" + queue +
                ", exchangeDlq=" + exchangeDlq +
                ", queueDlq=" + queueDlq +
                '}';
    }

    public void visit(Consumer<Rabbit> visitor){
        visitor.accept(this);
    }
}