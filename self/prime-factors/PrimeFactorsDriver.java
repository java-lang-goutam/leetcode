import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PrimeFactor {

    private final int N;
    private final int[] smallestPrimeFactors;

    public PrimeFactor(final int N) {
        this.N = N;
        this.smallestPrimeFactors = new int[N + 1];
        setSmallestPrimeFactors();
    }

    private void setSmallestPrimeFactors() {

        // setting all odd factors as self
        for (int i = 1; i < smallestPrimeFactors.length; i += 2) {
            smallestPrimeFactors[i] = i;
        }

        // set 2 as lowest prime factors for even numbers
        for (int i = 2; i < smallestPrimeFactors.length; i += 2) {
            smallestPrimeFactors[i] = 2;
        }

        for (int i = 3; i * i < smallestPrimeFactors.length; i += 2) {

            // factors which are not set
            if (smallestPrimeFactors[i] == i) {
                for (int j = i * i; j < smallestPrimeFactors.length; j += i) {
                    if (smallestPrimeFactors[j] == j) {
                        smallestPrimeFactors[j] = i;
                    }
                }
            }
        }
    }

    public List<Integer> getFactors(int num) {

        final List<Integer> result = new ArrayList<>();
        while (num != 1) {
            final int primeFactor = smallestPrimeFactors[num];
            result.add(primeFactor);
            num /= primeFactor;
        }

        return result;
    }

}

public class PrimeFactorsDriver {
    public static void main(String[] args) {
        final PrimeFactor primeFactor = new PrimeFactor(100000);
        System.out.println(primeFactor.getFactors(12246));
    }
}