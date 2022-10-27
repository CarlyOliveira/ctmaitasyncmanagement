package br.com.ctmait.asyncmanagement.abstraction.action;

import br.com.ctmait.asyncmanagement.domain.rabbit.Rabbit;

@FunctionalInterface
public interface CreateElementsRabbitAction {
    public void execute(Rabbit rabbit);
}
