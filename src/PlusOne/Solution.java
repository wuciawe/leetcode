package PlusOne;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int r = 1;
        for(int i = digits.length - 1; i >= 0; --i){
            r += digits[i];
            if(r > 9){
                digits[i] = r - 10;
                r = 1;
            }else{
                digits[i] = r;
                r = 0;
            }
        }
        if(r == 1){
            int[] t = new int[digits.length + 1];
            t[0] = 1;
            System.arraycopy(digits, 0, t, 1, digits.length);
            return t;
        }else{
            return digits;
        }
    }
}
