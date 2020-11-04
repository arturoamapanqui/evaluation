package com.proximity.api.bean;

import java.util.HashMap;

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
@ApiModel(value = "Transaction", description = "Entity for transactions")
public class Transaction {
	
	@ApiModelProperty
	private Integer id;
	
	@ApiModelProperty
	private String date;
	
	@ApiModelProperty
	private Machine machine;
	
	@ApiModelProperty
	private Product product;
	
	@ApiModelProperty
	private Double amount;
	
	@ApiModelProperty
	private Double amountInserted;
	
	@ApiModelProperty
	private Double change;
	
	@ApiModelProperty
	private PaymentMethod paymentMethod;
	
	@ApiModelProperty
	private HashMap<String, Integer> changeCoins;
	
}
