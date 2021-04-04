/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jesus
 */
public class CalculatorBasicServiceProviderTest {
    
    CalculatorBasicServiceProvider calculatorBasicServiceProvider;
    
    public CalculatorBasicServiceProviderTest() {
    }
   
    @Before
    public void setUp() {
        calculatorBasicServiceProvider= new CalculatorBasicServiceProvider();
    }
   

    /**
     * Test of sum method, of class CalculatorBasicServiceProvider.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
        double a = 2;
        double b = 3;
        double expResult = 5;
        double result = calculatorBasicServiceProvider.sum(a, b);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of subtrac method, of class CalculatorBasicServiceProvider.
     */
    @Test
    public void testSubtrac() {
        System.out.println("subtrac");
        double a = 9;
        double b = 7;
        CalculatorBasicServiceProvider instance = new CalculatorBasicServiceProvider();
        double expResult = 2;
        double result = instance.subtrac(a, b);
        assertEquals(expResult, result, 0.0);
    }
    
}
