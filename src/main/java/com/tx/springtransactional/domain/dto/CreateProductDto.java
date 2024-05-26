package com.tx.springtransactional.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductDto {

    private String productName;
    private Integer price;
    private Integer stock;
}
