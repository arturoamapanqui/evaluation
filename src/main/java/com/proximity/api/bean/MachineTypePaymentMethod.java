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
@ApiModel(value = "Machine Type and its payment method", description = "Entity for all payment methods available depending on machine type")
public class MachineTypePaymentMethod{
	
	@ApiModelProperty
	private Integer paymentMethodId;
	
}
