class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {

        // 1. Guard clauses for null and empty string
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }
        if (operation.isEmpty()) {
            throw new IllegalArgumentException("Operation cannot be empty");
        }

        int result;

        // 2. Switch handles valid cases and delegates invalid ones to 'default'
        switch (operation) {
            case "+":
                result = operand1 + operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
try {
                    result = operand1 / operand2;
                } catch (ArithmeticException e) {
                    // Pass 'e' as the second argument to chain the exception
                    throw new IllegalOperationException("Division by zero is not allowed", e);
                }
                break;
            default:
                throw new IllegalOperationException("Operation '" + operation + "' does not exist");
        }

        return String.format("%d %s %d = %d", operand1, operation, operand2, result);
    }
}