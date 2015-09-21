package ExpressionAddOperators;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haha on 2015/9/21.
 */
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num == null || num.length() == 0) return res;
        solve(res, target, num.toCharArray(), "", 0, 0, 0);
        return res;
    }

    private void solve(List<String> res, int target, char[] num, String path, int p, long value, long mult) {
        if(p == num.length){
            if(value == target) res.add(path);
        }else{
            long c = 0;
            for(int i = p; i < num.length; ++i){
                if(i != p && num[p] == '0') break;
                c = c * 10 + num[i] - '0';
                if(p == 0){
                    solve(res, target, num, path + c, i + 1, c, c);
                }else{
                    solve(res, target, num, path + '+' + c, i + 1, value + c, c);
                    solve(res, target, num, path + '-' + c, i + 1, value - c, -c);
                    solve(res, target, num, path + '*' + c, i + 1, value - mult + mult * c, mult * c);
                }
            }
        }
    }
}
