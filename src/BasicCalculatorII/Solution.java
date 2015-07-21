package BasicCalculatorII;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by haha on 2015/7/21.
 */
public class Solution {
    public int calculate(String s) {
        int res = 0;
        char[] cArr = s.toCharArray();
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> opts = new ArrayDeque<>();
        for(int i = 0; i < cArr.length; ++i){
            if(cArr[i] >= '0'){
                int num = 0;
                while(i < cArr.length && cArr[i] >= '0')
                    num = 10 * num + cArr[i++] - '0';
                nums.addLast(num);
                --i;
            }else{
                switch (cArr[i]) {
                    case '+':
                    case '-':
                        opts.addLast(cArr[i]);
                        break;
                    case ' ':
                        break;
                    default:
                        char opt = cArr[i];
                        while(cArr[++i] == ' ');
                        int num = 0;
                        while(i < cArr.length && cArr[i] >= '0')
                            num = 10 * num + cArr[i++] - '0';
                        if(opt == '*') {
                            nums.addLast(nums.removeLast() * num);
                        } else {
                            nums.addLast(nums.removeLast() / num);
                        }
                        --i;
                }
            }
        }
        res = nums.removeFirst();
        while(!opts.isEmpty()){
            switch (opts.removeFirst()) {
                case '+':
                    res += nums.removeFirst();
                    break;
                default:
                    res -= nums.removeFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.calculate(" 3+5 / 2 "));
    }
}
