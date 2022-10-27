package br.com.ctmait.asyncmanagement.abstraction.processor;

import br.com.ctmait.asyncmanagement.domain.rabbit.Rabbit;

@FunctionalInterface
public interface CreateElementsRabbitProcessor {
    public void execute(Rabbit rabbit);
}
