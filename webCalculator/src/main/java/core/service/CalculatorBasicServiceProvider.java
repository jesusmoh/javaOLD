/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.service;

/**
 *
 * @author jesus
 */
public class CalculatorBasicServiceProvider {
    
    private double a;
    private double b;

    public CalculatorBasicServiceProvider(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public CalculatorBasicServiceProvider() {
    }

    
    
    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
    
    
    public double sum(double a, double b) {
        return a+b;
    }

    
    public double subtrac(double a, double b) {
        return a-b;
    }
    
}
