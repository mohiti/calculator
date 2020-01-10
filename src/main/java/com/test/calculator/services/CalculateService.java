package com.test.calculator.services;

import com.test.calculator.model.CalculateDTO;
import com.test.calculator.model.CalculateResult;

public interface CalculateService {
    CalculateResult addOperation(CalculateDTO dto);
    CalculateResult subtractOperation(CalculateDTO dto);
    CalculateResult multiplyOperation(CalculateDTO dto);
    CalculateResult divideOperation(CalculateDTO dto);
    CalculateResult squareOperation(CalculateDTO dto);
    CalculateResult factorialOperation(CalculateDTO dto);
    String NumberIsPrimeOperation(CalculateDTO dto);




}
