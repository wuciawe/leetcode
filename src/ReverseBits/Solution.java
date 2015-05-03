package ReverseBits;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public int reverseBits(int n) {
        int result = (n & 1) << 31;
        for(int i = 1; i < 32; ++i){
            n = n >>> 1;
            if(n == 0) break;
            if((n & 1) > 0){
                result |= (1 << (31 - i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverseBits(43261596));
    }
}
