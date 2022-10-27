package br.com.ctmait.asyncmanagement.tech.rest.payload.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueuePayloadOut {

    private String name;
    private String routingKey;

}