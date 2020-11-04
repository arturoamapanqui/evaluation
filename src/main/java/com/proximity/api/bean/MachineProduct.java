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
@ApiModel(value = "Machine products", description = "Entity for all products available in a machine")
public class MachineProduct{
	
	@ApiModelProperty
	private Integer machineId;
	
	@ApiModelProperty
	private Integer productId;
	
	@ApiModelProperty
	private Double quantity;
	
}
