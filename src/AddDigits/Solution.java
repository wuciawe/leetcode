package AddDigits;

/**
 * Created by haha on 2015/9/6.
 */
public class Solution {
    public int addDigits(int num) {
        return num - 9 * ((num - 1) / 9);
    }
}
