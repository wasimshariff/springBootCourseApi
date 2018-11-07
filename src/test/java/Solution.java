import antlr.collections.impl.IntRange;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static int reverse(int A) {

        boolean isNegative = false;
        int r = 0;int sum = 0;
        try {


            while ( A != 0) {
                r = A%10;
                long sumLong = (long) sum*10 + r;
                if ( Integer.MIN_VALUE > sumLong || Integer.MAX_VALUE < sumLong)
                    return 0;
                sum = sum*10+r;
                A= A /10;
            }
        } catch(NumberFormatException e) {
            return 0;
        }

        return sum;
    }

    public static void sieve(int A) {

        List<Integer> primes = new ArrayList<>();
        if( A > 1) {
            IntStream.rangeClosed(2, A).filter(Solution::isPrime).forEach(i -> primes.add(i));
        }
        System.out.println(primes);

    }

    private static boolean isPrime(int i) {
        if ( i %2 ==0) {
            return false;
        }
        boolean isNotPrime = IntStream.rangeClosed(2, i/2)
                    .filter(k -> i%k == 0)
                    .findFirst()
                    .isPresent();
        return !isNotPrime;
    }

    public static void main(String a[]) {
        System.out.println(Math.sqrt(6));
        System.out.println(reverse(-1234567891));
        sieve(7);
    }
}
