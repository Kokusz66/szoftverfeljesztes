package pti.gyak;

import java.util.Collections;
import java.util.List;

public class Calculator {
    private String separator = " ";

    private Number result = 0;
    private String expression = "";
    private List<String> history = Collections.emptyList();

    private Operation lastOperation;

    public Number getResult(){
        return result;
    }

    public Calculator enter(Number number) {
        if (number != null) {
            if (lastOperation != null) {
                if (lastOperation.equals(Operation.ADD)) {
                    result = result.doubleValue() + number.doubleValue();
                } else if (lastOperation.equals(Operation.SUBSTRACT)) {
                    result = result.doubleValue() - number.doubleValue();
                } else if (lastOperation.equals(Operation.MULTIPLY)) {
                    result = result.doubleValue() * number.doubleValue();
                } else if (lastOperation.equals(Operation.DIVIDE)) {
                    if (number.doubleValue() != 0) {
                        result = result.doubleValue() / number.doubleValue();
                    } else {
                        if (result.doubleValue() > 0) {
                            result = Double.POSITIVE_INFINITY;
                        } else {
                            result = Double.NEGATIVE_INFINITY;
                        }
                    }
                } else if (lastOperation.equals(Operation.REMAINDER)) {
                    result = result.doubleValue() % number.doubleValue();
                } else if (lastOperation.equals(Operation.POWER)) {
                    result = Math.pow(result.doubleValue(), number.doubleValue());
                }
                expression = expression + separator + lastOperation + separator + number;
                lastOperation = null;
            } else {
                if (!expression.isEmpty()) {
                    history.add(expression + " = " + resultString());
                }
                result = number;
                expression = "" + number;
            }
        }
        return this;
    }

    public Calculator enter(Operation operation) {
        if (operation != null) {
            if (operation == Operation.ADD || operation == Operation.SUBSTRACT || operation == Operation.MULTIPLY
                    || operation == Operation.DIVIDE || operation == Operation.REMAINDER || operation == Operation.POWER) {
                lastOperation = operation;
            } else if (operation == Operation.SQRT) {
                result = Math.sqrt(result.doubleValue());
                expression = operation + "(" + expression + ")";
                lastOperation = null;
            } else if (operation == Operation.CLEAR) {
                result = 0;
                expression = "";
                lastOperation = null;
            }
            return this;
        }
        return this;
    }

    public String getHistory() {
        StringBuilder sb = new StringBuilder();
        if (history.isEmpty())
            for (String h: history) {
                sb.append(h).append("\n");
            }

        sb.append(expression).append(" = ").append(resultString());
        return sb.toString();
    }

    private String resultString() {
        return result.doubleValue() % 1 == 0 ? "" + result.intValue() : result.toString();
    }
}