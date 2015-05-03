package PalindromeNumber;

/**
 * Created by haha on 2015/4/17.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int base = 1;
        while(x / base > 9){
            base *= 10;
        }
        while(base > 1){
            if(x % 10 != x / base) return false;
            x %= base;
            x /= 10;
            base /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.isPalindrome(1);
    }
}
