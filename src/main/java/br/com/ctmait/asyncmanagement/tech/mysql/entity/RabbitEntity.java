package br.com.ctmait.asyncmanagement.tech.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_rabbit",
		indexes = {@Index(name = "business_id_index",  columnList="uuid", unique = true),
				@Index(name = "queuename_index",  columnList="queueName", unique = true)})
public class RabbitEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String uuid;
	private String exchangeName;
	private String exchangeType;
	private String queueName;
	private String routingKey;
	private String exchangeNameDlq;
	private String exchangeTypeDlq;
	private String queueNameDlq;
	private String routingKeyDlq;
	@CreationTimestamp
	private LocalDate createdAt;
}
