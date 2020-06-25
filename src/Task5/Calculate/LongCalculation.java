package Task5.Calculate;

public interface LongCalculation {
    default long add(long val1, long val2 ){
        return (val1 + val2);
    }

    default long minus(long val1, long val2 ){
        return (val1 - val2);
    }

    default long multiply(long val1, long val2){
        return (val1 * val2);
    }

    default double divide(long val1, long val2){
        return ((double) val1 /(double)  val2);
    }
}
