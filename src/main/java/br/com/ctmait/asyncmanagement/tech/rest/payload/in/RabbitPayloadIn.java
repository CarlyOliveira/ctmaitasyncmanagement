package br.com.ctmait.asyncmanagement.tech.rest.payload.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RabbitPayloadIn {

	private String exchangeName;
	private String exchangeType;
	private String queueName;
	private String routingKey;
	private String exchangeNameDlq;
	private String exchangeTypeDlq;
	private String queueNameDlq;
	private String routingKeyDlq;

}