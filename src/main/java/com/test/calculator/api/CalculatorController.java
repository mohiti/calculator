package com.test.calculator.api;

import com.test.calculator.model.CalculateDTO;
import com.test.calculator.model.CalculateResult;
import com.test.calculator.services.CalculateServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1")
@Api(value="Calculator Rest Api")
public class CalculatorController {

    public static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @Autowired
    CalculateServiceImpl calculateService;

    @ApiOperation(value = "Adds two numbers passed as path parameters : number1 + number2", response = ResponseEntity.class)
    @GetMapping(value = "/add")
    public ResponseEntity<CalculateResult> addCalculate(  CalculateDTO calculateDTO ) {
        logger.info("User Call this Operator : add");



        CalculateResult calculateResult = calculateService.addOperation(calculateDTO);

        return new ResponseEntity<CalculateResult>(calculateResult, HttpStatus.OK);
    }

    @ApiOperation(value = "Subtract two numbers passed as path parameters : number1 - number2", response = ResponseEntity.class)
    @GetMapping(value = "/subtract")
    public ResponseEntity<CalculateResult> subtractCalculate(CalculateDTO calculateDTO ) {
        logger.info("User Call this Operator : subtract");

        CalculateResult calculateResult = calculateService.subtractOperation(calculateDTO);

        return new ResponseEntity<CalculateResult>(calculateResult, HttpStatus.OK);
    }

    @ApiOperation(value = "Multiply two numbers passed as path parameters  : number1 * number2", response = ResponseEntity.class)
    @GetMapping(value = "/multiply")
    public ResponseEntity<CalculateResult> multiplyCalculate(CalculateDTO calculateDTO ) {
        logger.info("User Call this Operator : multiply");

        CalculateResult calculateResult = calculateService.multiplyOperation(calculateDTO);
        return new ResponseEntity<CalculateResult>(calculateResult, HttpStatus.OK);
    }

    @ApiOperation(value = "Division two numbers passed as path parameters  : number1 / number2", response = ResponseEntity.class)
    @GetMapping(value = "/divide")
    public ResponseEntity<CalculateResult> divideCalculate( CalculateDTO calculateDTO) {
        logger.info("User Call this Operator : divide");




        CalculateResult calculateResult  = calculateService.divideOperation(calculateDTO);
        return new ResponseEntity<CalculateResult>(calculateResult, HttpStatus.OK);
    }


    @ApiOperation(value = "Square a number passed as path parameter  : number1", response = ResponseEntity.class)
    @GetMapping(value = "/square")
    public ResponseEntity<CalculateResult> squareCalculate(CalculateDTO calculateDTO ) {
        logger.info("User Call this Operator : square");



        CalculateResult calculateResult = calculateService.squareOperation(calculateDTO);
            return new ResponseEntity<CalculateResult>(calculateResult, HttpStatus.OK);
    }

    @ApiOperation(value = "Factorial a number passed as path parameter  : number1", response = ResponseEntity.class)
    @GetMapping(value = "/factorial")
    public ResponseEntity<CalculateResult> factorialCalculate(CalculateDTO calculateDTO ) {
        logger.info("User Call this Operator : factorial");

        if(calculateDTO.getNumber1().compareTo(new BigDecimal(0)) < 0)
        {
            logger.error("Error : factorial only accepts  Integer values greater than or equal Zero");
            return new ResponseEntity("Error : factorial only accepts  Integer values greater than or equal Zero",
                    HttpStatus.BAD_REQUEST);
        }

        CalculateResult calculateResult  = calculateService.factorialOperation(calculateDTO);
        return new ResponseEntity<CalculateResult>(calculateResult, HttpStatus.OK);
    }

    @ApiOperation(value = "Check a number passed as path parameter is prime or not  : number1", response = ResponseEntity.class)
    @GetMapping(value = "/prime")
    public ResponseEntity<String> primeCalculate(CalculateDTO calculateDTO ) {
        logger.info("User Call this Operator : prime");
        String res = calculateService.NumberIsPrimeOperation(calculateDTO);
        return new ResponseEntity<String>(res, HttpStatus.OK);
    }



}
