package com.cisco.alex.algs.collections;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Supported operations.
 *
 * @author oleivano
 */
public enum Operations implements Executor {
    /**
     * This value for undefined state/operation.
     */
    NONE("NONE") {
        @Override
        public double execute(double leftOperand, double rightOperand) {
            throw new UnsupportedOperationException("This operation is not supported yet or not exists.");
        }
    },
    // Priority must increase from top to the bottom
    PLUS("+") {
        @Override
        public double execute(double leftOperand, double rightOperand) {
            return leftOperand + rightOperand;
        }
    },
    MINUS("-") {
        @Override
        public double execute(double leftOperand, double rightOperand) {
            return leftOperand - rightOperand;
        }
    },
    MULTIPLY("*") {
        @Override
        public double execute(double leftOperand, double rightOperand) {
            return leftOperand * rightOperand;
        }
    },
    DIVISION("/") {
        @Override
        public double execute(double leftOperand, double rightOperand) {
            return leftOperand / rightOperand;
        }
    };

    public static final Map<String, Operations> ALL_VALUES;

    static {
        ALL_VALUES = EnumSet.range(PLUS, DIVISION).stream()
                .collect(Collectors.toMap(Operations::getRepresentation, Function.identity()));
    }

    final String representation;

    Operations(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    public static Operations parseOperation(String stringValue) {
        return ALL_VALUES.getOrDefault(stringValue, NONE);
    }
}
