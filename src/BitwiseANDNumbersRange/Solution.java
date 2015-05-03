package BitwiseANDNumbersRange;

/**
 * Created by haha on 2015/4/29.
 */
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int result = m & n;
        n -= m;
        int i = 0;
        while(m != 0){
            int b = 1 << i;
            if(b <= n){
                result &=  ~b;
            }
            m >>>= 1;
            ++i;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.rangeBitwiseAnd(3, 4));
    }
}
