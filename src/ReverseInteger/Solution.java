package ReverseInteger;

/**
 * Created by haha on 2015/4/17.
 */
public class Solution {
    public static int reverse(int x){
        int result = 0;
        while(x != 0){
            int mod = x % 10;
            if(result >= 214748364){
                if(result > 214748364) return 0;
                if(mod > 7) return 0;
            }else if(result <= -214748364){
                if(result < -214748364) return 0;
                if(mod < -7) return 0;
            }
            result = 10 * result + mod;
            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Solution.reverse(1534236469));
        System.out.println(Solution.reverse(-1534236469));
        System.out.println(Integer.MAX_VALUE);
    }
}
