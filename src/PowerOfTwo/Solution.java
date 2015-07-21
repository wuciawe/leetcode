package PowerOfTwo;

/**
 * Created by haha on 2015/7/21.
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
