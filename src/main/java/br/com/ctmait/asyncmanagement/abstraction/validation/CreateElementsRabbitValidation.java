package br.com.ctmait.asyncmanagement.abstraction.validation;

import br.com.ctmait.asyncmanagement.domain.rabbit.Rabbit;

@FunctionalInterface
public interface CreateElementsRabbitValidation {
    public void execute(Rabbit rabbit);
}
