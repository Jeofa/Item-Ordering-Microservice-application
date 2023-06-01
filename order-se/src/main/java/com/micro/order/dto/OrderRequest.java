package com.micro.order.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderRequest {
	
	private List<OrderLineItemsDto> orderLineItemsDto;
	
}
