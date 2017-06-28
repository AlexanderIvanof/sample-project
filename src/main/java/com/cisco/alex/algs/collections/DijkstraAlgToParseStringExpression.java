package com.cisco.alex.algs.collections;

import java.util.Objects;

/**
 * String parser
 *
 * @author oleivano
 */
public class DijkstraAlgToParseStringExpression {

    private Stack<Operations> stackOfOperations;
    private Stack<Double> stackOfOperands;

    public DijkstraAlgToParseStringExpression() {
        stackOfOperands = new ResizeTwiceCapacityStack<>();
        stackOfOperations = new ResizeTwiceCapacityStack<>();
    }

    private void evaluate() {
        Operations operation = stackOfOperations.pop();
        final Double rightOperand = stackOfOperands.pop();
        final Double leftOperand = stackOfOperands.pop();
        final double currentResult = operation.execute(leftOperand, rightOperand);
        stackOfOperands.push(currentResult);
    }

    public double evaluate(String mathExpression) {
        Objects.requireNonNull(mathExpression);

        outer:
        for (int i = 0; i < mathExpression.length(); i++) {
            char charAt = mathExpression.charAt(i);
            if (charAt == '(') {
                continue;
            } else if (charAt == '+' || charAt == '-') {
                final Operations previousOperation = stackOfOperations.peek();
                if (previousOperation == Operations.PLUS || previousOperation == Operations.MINUS) {
                    evaluate();
                }
                final Operations operation = Operations.parseOperation(String.valueOf(charAt));
                stackOfOperations.push(operation);
            } else if (charAt == '/' || charAt == '*') {
                final Operations previousOperation = stackOfOperations.peek();
                if (previousOperation == Operations.MULTIPLY || previousOperation == Operations.DIVISION) {
                    evaluate();
                }
                final Operations operation = Operations.parseOperation(String.valueOf(charAt));
                stackOfOperations.push(operation);
            } else if (charAt == ')') {
                evaluate();
            } else {
                StringBuilder sj = new StringBuilder();
                int currentIndex = i;
                while (Character.isDigit(charAt)) {
                    sj.append(charAt);
                    if (currentIndex < mathExpression.length() - 1) {
                        charAt = mathExpression.charAt(++currentIndex);
                    } else {
                        stackOfOperands.push(Double.parseDouble(sj.toString()));
                        break outer;
                    }
                }
                stackOfOperands.push(Double.parseDouble(sj.toString()));
                i = --currentIndex;
            }
        }
        while (stackOfOperands.size() != 1) {
            evaluate();
        }
        return stackOfOperands.pop();
        // 1+2*3
        // (7-1)/(1+1)*(1+2)
    }

    public static void main(String[] args) {
        String str = "2*2+3";
        DijkstraAlgToParseStringExpression ds = new DijkstraAlgToParseStringExpression();
        final double evaluate = ds.evaluate(str);
        System.out.println(evaluate);


    }
}
