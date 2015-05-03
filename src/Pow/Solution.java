package Pow;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n < 0){
            x = 1 / x;
            n = -(n + 1);
        }else{
            n = n - 1;
        }
        double result = x;
        double res = solver(x, n / 2);
        if(n % 2 == 0){
            return result * res * res;
        }else{
            return result * res * res * x;
        }
    }

    private double solver(double x, int n){
        if(n == 0) return 1;
        double res = solver(x, n / 2);
        if(n % 2 == 0){
            return res * res;
        }else{
            return res * res * x;
        }
    }
}
