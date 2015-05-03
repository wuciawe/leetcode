package CountPrimes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;

        final boolean[] nonPrime = new boolean[n + 1];
        for (int candy = 3; candy <= Math.sqrt(n); candy += 2) {
            if (!nonPrime[candy]) {
                for (int j = candy * 3; j < n; j += candy) {
                    nonPrime[j] = true;
                }
            }
        }

        int cnt = 1;
        for (int candy = 3; candy < n; candy += 2) {
            if (!nonPrime[candy]) ++cnt;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(5000000 / ((Math.log(5000000) / Math.log(Math.E)) - 1));
        System.out.println(5000000 / ((Math.log(5000000) / Math.log(Math.E)) - 1.1));
    }
}
