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
@ApiModel(value = "Machine", description = "Entity for machines")
public class Machine {
	
	@ApiModelProperty
	private Integer id;
	
	@ApiModelProperty
	private Integer capacity;
	
	@ApiModelProperty
	private Double balance;
	
	@ApiModelProperty
	private Boolean isConnected;
	
	@ApiModelProperty
	private Boolean isReadyToPickup;
	
	@ApiModelProperty
	private MachineType type;
	
	@ApiModelProperty
	private List<MachineProduct> products;
	
}
