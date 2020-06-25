package Task5.Calculate;

public interface FloatCalculation {
    default float add(float val1, float val2 ){
        return (val1 + val2);
    }

    default float minus(float val1, float val2 ){
        return (val1 - val2);
    }

    default float multiply(float val1, float val2){
        return (val1 * val2);
    }

    default double divide(float val1, float val2){
        return ((double) val1 / (double) val2);
    }
}
