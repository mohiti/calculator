package com.test.calculator.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Data
@NoArgsConstructor
public class CalculateDTO {


    private BigDecimal number1;

    private BigDecimal number2;


    public CalculateDTO(BigDecimal number1, BigDecimal number2) {
        this.number1 = number1;
        this.number2 = number2;
    }


    public CalculateDTO(BigDecimal number1) {
        this.number1 = number1;

    }
}
