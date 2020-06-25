package Task5.Calculate;

public interface IntegerCalculation {
    default int add(int val1, int val2 ){
        return (val1 + val2);
    }

    default int minus(int val1, int val2 ){
        return (val1 - val2);
    }

    default int multiply(int val1, int val2){
        return (val1 * val2);
    }

    default double divide(int val1, int val2){
        return ((double) val1 / (double) val2);
    }
}
