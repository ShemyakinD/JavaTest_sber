package Task5.Calculate;

public interface DoubleCalculation {

    default double add(double val1, double val2 ){
        return (val1 + val2);
    }

    default double minus(double val1, double val2){
        return (val1 - val2);
    }

    default double multiply(double val1, double val2){
        return (val1 * val2);
    }

    default double divide(double val1, double val2){
        return (val1 / val2);
    }

    default double sqrt(double val1) throws CalcCustomException{
        if (val1 < 0 )
            throw new CalcCustomException("Нельзя взять корень отрицательного числа " + val1);
        return Math.sqrt(val1);
    }

    default double degree(double val1, int val2) {
        double res = 1;
        if (val2 == 0)
            return 1.0D;
        else {
            while (val2 > 0)
            {
                res = res * val1;
                val2--;
            }
            return res;
        }

    }

}
