package br.com.ctmait.asyncmanagement.tech.rest.exception.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionPayload {
	private final String error;
	private final String error_description;
}
