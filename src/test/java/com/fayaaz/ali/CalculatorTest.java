package com.fayaaz.ali;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class CalculatorTest {
    private Calculator calculator;
    private CalculatorService calculatorServiceMock;


    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class...");
    }

    @Before
    public void setUp() {
        calculatorServiceMock = Mockito.mock(CalculatorService.class);
        calculator = new Calculator(calculatorServiceMock);
        System.out.println("Setup......");
    }

    @Test
    public void shouldReturnInstanceOfACalculator() {
        Assert.assertNotNull(calculator);
    }

    @Test
    public void shouldReturnTwoWhenOnePlusOneCalledOnAdd() {
        Mockito.when(calculatorServiceMock.add(1, 1)).thenReturn(2);
        int result = calculator.add(1, 1);
        Assert.assertEquals(result, 2);
        Mockito.verify(calculatorServiceMock).add(1, 1);
    }
}
