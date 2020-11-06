package com.proximity.api.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@ApiModel(value = "Machine Transactions", description = "Entity for reports - Machine transactions")
public class MachineTransaction {
	
	@ApiModelProperty
	private Integer machineId;
	
	@ApiModelProperty
	private String machineType;
	
	@ApiModelProperty
	private String paymentMethod;
	
	@ApiModelProperty
	private Integer transactionId; 
	
	@ApiModelProperty
	private Double change;
	
	@ApiModelProperty
	private String transactionDate;
	
	@ApiModelProperty
	private Integer productId;
	
	@ApiModelProperty
	private String productName;
	
}
