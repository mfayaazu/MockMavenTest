package com.fayaaz.ali;

public class Calculator {
    private CalculatorService calculatorService;

    public Calculator(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }



    public int add(int first, int second) {
      //  if (first < 0 || second < 0) {
        //    throw new RuntimeException("Non negative numbers allowed");
       // }
        return calculatorService.add(first, second);
    }
}
