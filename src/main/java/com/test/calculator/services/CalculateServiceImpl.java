package com.test.calculator.services;

import com.test.calculator.exception.BadRequestException;
import com.test.calculator.model.CalculateDTO;

import com.test.calculator.model.CalculateResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class CalculateServiceImpl implements CalculateService {


    // this function does add operation
    public CalculateResult addOperation(CalculateDTO dto)
    {
        // this line add for check if any required operand is null, return exception
        if(dto.getNumber1() == null || dto.getNumber2() ==  null)
            throw new BadRequestException();

        CalculateResult res =  new CalculateResult(  dto.getNumber1().add( dto.getNumber2()));

        return res;

    }


    // this function does subtract operation
    public CalculateResult subtractOperation(CalculateDTO dto)
    {
        // this line add for check if any required operand is null, return exception
        if(dto.getNumber1() == null || dto.getNumber2() ==  null)
            throw new BadRequestException();

        CalculateResult res =  new CalculateResult(  dto.getNumber1().subtract( dto.getNumber2()));

        return res;

    }


    // this function does multiply operation
    public CalculateResult multiplyOperation(CalculateDTO dto)
    {
        // this line add for check if any required operand is null, return exception
        if(dto.getNumber1() == null || dto.getNumber2() ==  null)
            throw new BadRequestException();


        CalculateResult res =  new CalculateResult(  dto.getNumber1().multiply(dto.getNumber2()));

        return res;

    }

    // this function does divide operation
    public CalculateResult divideOperation(CalculateDTO dto)
    {
        // this line add for check if any required operand is null, return exception
        if(dto.getNumber1() == null || dto.getNumber2() ==  null)
            throw new BadRequestException();
        // this line add for catch divide by zero exception
        if( dto.getNumber2().compareTo(new BigDecimal(0)) == 0)
            throw new BadRequestException();


        CalculateResult res =  new CalculateResult(  dto.getNumber1().divide(dto.getNumber2()));

        return res;

    }

    // this function does square operation
    public CalculateResult squareOperation(CalculateDTO dto)
    {
        // this line add for check if any required operand is null, return exception
        if(dto.getNumber1() == null )
            throw new BadRequestException();

        CalculateResult res =  new CalculateResult( dto.getNumber1().multiply( dto.getNumber1()));

        return res;

    }

    // this function does factorial operation
    public CalculateResult factorialOperation(CalculateDTO dto) {
        // this line add for check if any required operand is null, return exception
        if(dto.getNumber1() == null )
            throw new BadRequestException();

        BigInteger n = dto.getNumber1().toBigInteger();
        n = factorial(n);
        //dto.setResultNumber(n.doubleValue());

        CalculateResult res =  new CalculateResult(  new BigDecimal(n));
        return  res;
    }



    //this function is a recursive function that calculate factorial
    public BigInteger factorial(BigInteger n) {
        BigInteger res;
        if (n == BigInteger.ZERO) {
            res = BigInteger.ONE;
        } else {
            res = n.multiply(factorial(n.subtract(BigInteger.ONE)));
        }

        return res;
    }

    // this function does is prime operation
    public String NumberIsPrimeOperation(CalculateDTO dto) {
        // this line add for check if any required operand is null, return exception
        if(dto.getNumber1() == null )
            throw new BadRequestException();

        //this line check if input number is less than zero , then return exception
       if(dto.getNumber1().compareTo(new BigDecimal(0)) < 0)
           throw new BadRequestException();

        boolean isPrime = NumberIsPrime(dto.getNumber1().intValue());
        String message = "";
        if(isPrime)
            message = dto.getNumber1().intValue() + " is a prime number";
        else
            message = dto.getNumber1().intValue() +  " is not a prime number";

        return  message;
    }

    //this function check number is prime or not
    public boolean NumberIsPrime(int n) {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }


    //this function check the string is number or not
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
