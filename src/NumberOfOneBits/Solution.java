package NumberOfOneBits;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public static int hammingWeight(int n) {
        int result = n & 1;
        for(int i = 1; i < 32; ++i){
            n = n >>> 1;
            if(n == 0) break;
            result += n & 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Solution.hammingWeight(-11));
        System.out.println(Integer.bitCount(-11));
    }
}
