package UglyNumber;

/**
 * Created by haha on 2015/9/6.
 */
public class Solution {
    public boolean isUgly(int num) {
        if(num <= 0) return false;
        while(num % 2 == 0) num /= 2;
        while(num % 3 == 0) num /= 3;
        while(num % 5 == 0) num /= 5;
        return num == 1;
    }
}
