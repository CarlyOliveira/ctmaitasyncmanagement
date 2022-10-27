package br.com.ctmait.asyncmanagement.domain.rabbit;


import java.util.Objects;

public class Queue {

    private String name;
    private String routingKey;

    public Queue() {
    }

    public Queue(String name, String routingKey) {
        this.name = name;
        this.routingKey = routingKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Queue)) return false;
        Queue queue = (Queue) o;
        return Objects.equals(getName(), queue.getName()) && Objects.equals(getRoutingKey(), queue.getRoutingKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getRoutingKey());
    }

    @Override
    public String toString() {
        return "Queue{" +
                "name='" + name + '\'' +
                ", routingKey='" + routingKey + '\'' +
                '}';
    }
}