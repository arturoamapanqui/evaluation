package com.proximity.api.bean;

import java.util.List;

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
@ApiModel(value = "Machine Type", description = "Entity for machine types")
public class MachineType {
	
	@ApiModelProperty
	private Integer id;
	
	@ApiModelProperty
	private String name;
	
	@ApiModelProperty
	private List<MachineTypePaymentMethod> paymentMethods;
	
}
