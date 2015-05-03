package FractionToRecurringDecimal;

import java.util.HashMap;

/**
 * Created by haha on 2015/4/28.
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean samSign = numerator > 0 && denominator > 0 || numerator < 0 && denominator < 0 || numerator == 0;
        long num = numerator;
        long den = denominator;
        if(numerator < 0) num = -(long)numerator;
        if(denominator < 0) den = -(long)denominator;

        long dec = num / den;
        long remain = num % den;

        StringBuilder sb = new StringBuilder();
        if(!samSign){
            sb.append('-');
        }
        sb.append(dec);

        if(remain > 0){
            sb.append('.');

            StringBuilder r = new StringBuilder();
            int idx = 0;
            HashMap<Long, Integer> map = new HashMap<Long, Integer>();

            while(remain > 0){
                if(map.containsKey(remain)){
                    idx = map.get(remain);
                    r.insert(idx, '(');
                    r.append(')');
                    break;
                }
                map.put(remain, idx++);
                remain *= 10;
                dec = remain / den;
                remain = remain % den;
                r.append(dec);
            }
            sb.append(r);
        }

        return sb.toString();
    }
}
