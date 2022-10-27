package br.com.ctmait.asyncmanagement.abstraction.action;

import br.com.ctmait.asyncmanagement.domain.rabbit.Rabbit;

@FunctionalInterface
public interface GetElementsRabbitAction {
    public Rabbit execute(String id);
}
