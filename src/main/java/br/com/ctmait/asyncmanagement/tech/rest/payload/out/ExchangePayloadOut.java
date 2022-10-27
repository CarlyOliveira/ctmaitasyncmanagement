package br.com.ctmait.asyncmanagement.tech.rest.payload.out;

import br.com.ctmait.asyncmanagement.tech.rest.payload.ExchangeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangePayloadOut {

    private ExchangeType exchangeType;
    private String name;

}
