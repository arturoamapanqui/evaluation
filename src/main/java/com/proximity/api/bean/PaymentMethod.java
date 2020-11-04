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
@ApiModel(value = "Payment Method", description = "Entity for payment methods available")
public class PaymentMethod {
	
	@ApiModelProperty
	private Integer id;
	
	@ApiModelProperty
	private String name;
	
}
