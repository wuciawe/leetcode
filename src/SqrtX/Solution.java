package SqrtX;

/**
 * Created by haha on 2015/4/24.
 */
public class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        double xk = x;
        double xk1 = x;
        do{
            xk = xk1;
            xk1 = (xk + x / xk) / 2;
        }while(Math.abs(xk1 - xk) >= 1);
        return (int)xk1;
    }

    public int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int l = 0, r = Integer.MAX_VALUE;
        while (l < r) {
            int mid = (l + r) / 2;
            int tmp = x / mid;
            if (mid == tmp) {
                return mid;
            } else if(mid > tmp) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.sqrt(3);
    }

}
