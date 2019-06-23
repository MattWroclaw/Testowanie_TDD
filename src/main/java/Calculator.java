

/**
 * Klasa do wykonywania działań matematycznych
 */
public final class Calculator {
    /**
     * @param numberA Pierwsza liczba wchodząca w skład działania
     * @param numberB Druga liczba wchodząca w skład działania
     * @return Suma dwóch liczb
     */
    public static double sum(double numberA, double numberB){
        return numberA + numberB;
    }

    public static int sum(int numberA, int numberB){
        return numberA+numberB;
    }

    /**
     * @param numberA Pierwsza liczba wchodząca w skład działania
     * @param numberB Druga liczba wchodząca w skład działania
     * @return Różnica dwóch liczb
     */
    public static double substraction(double numberA, double numberB){
        return numberA - numberB;
    }

    /**
     * @param multiplicand Mnożna
     * @param multiplier Mnożnik
     * @return Iloczyn dwóch liczb
     */
    public static double multiply(double multiplicand, double multiplier){
        return multiplicand * multiplier;
    }

    /**
     * @param dividend Dzielna
     * @param divider Dzielnik
     * @return Iloraz dwóch liczb
     */
    public static double divide(double dividend, double divider){
        if(divider == 0.0){
            throw new IllegalArgumentException("Ty cholero nie dziel przez 0");
        }

        return dividend / divider;
    }

    /**
     * @param n Identyfikator liczby fibonaciego
     * @return Liczba fibonaciego
     */
    public static int getFibonaciNumber(int n)
    {
        if(n < 0){
            throw new IllegalArgumentException("Liczby fibonaciego mozna obliczyć tylko z liczb dodatnich");
        }

        if(n <= 1)
        {
            return n;
        }

        return getFibonaciNumber(n-1) + getFibonaciNumber(n-2);
    }

    public static double log(double a, double x){
        if (a<=0.0){
            throw new IllegalArgumentException("Podstawa logarytmu musi być  > 0");
        }

        if (x<=0.0){
            throw new IllegalArgumentException("Liczba logarytmowana musi być  => 0");
        }

        if (a ==1.0){
            throw new IllegalArgumentException("Podstawa logarytmu musi być różna od 1");
        }


        return Math.log(x)/Math.log(a); //log aX

        //a, bo >0
        // a !=0

    }

    public static double doKwadratu(double i) {
        return  i*i;
    }

    public static double doPotegiN(double a, double b) {
        return Math.pow(a,b);
    }

    public static double squareRoot(double a) {
        if (a<0){
            throw new IllegalArgumentException("Podstawa musi być >0");
        }
        return Math.sqrt(a);
    }


    public static double nRootK(double n, double k) {
        return Math.pow(k, 1/n);
    }
}
