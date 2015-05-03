package GenerateParenthese;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haha on 2015/4/12.
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if(n == 0) return result;
        solve(result, "", n, n);
        return result;
    }

    private void solve(List<String> result, String current, int l, int r){
        if(r == 0){
            result.add(current);
            return;
        }
        if(l == 0){
            solve(result, current + ")", l, r - 1);
        }else{
            if(l < r){
                solve(result, current + ")", l, r - 1);
            }
            solve(result, current + "(", l - 1, r);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.generateParenthesis(3);
    }
}
