package utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import net.objecthunter.exp4j.ExpressionBuilder;

public class MathOperation {
    
    public static BigInteger evaluateMathExpression(String expression) {
        try {
            double result = new ExpressionBuilder(expression)
                    .build()
                    .evaluate();
            
            return BigDecimal.valueOf(result)
                    .setScale(0, RoundingMode.HALF_UP)
                    .toBigInteger();
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid mathematical expression: " + expression, e);
        }
    }

    public static void main(String[] args) {
        String expression = "191+240*37*74*143*185*214-276*102";
        BigInteger result = evaluateMathExpression(expression);
        System.out.println("Result: " + result);
    }
}
