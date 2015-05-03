package HappyNumber;

import java.util.HashSet;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        while(!set.contains(n)){
            set.add(n);
            int sum = 0;
            while(n != 0){
                int t = n % 10;
                sum += t * t;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isHappy(19));
    }
}
