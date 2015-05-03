package RestoreIPAddr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haha on 2015/4/29.
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        solver(s, 0, s.length(), 1, "", result);
        return result;
    }

    private void solver(String s, int idx, int len, int n, String cur, List<String> result){
        if(len == 0 && n == 5){
            result.add(cur.substring(0, cur.length() - 1));
        }else if(len > 0 && n < 5){
            switch (s.charAt(idx)){
                case '0':
                    solver(s, idx + 1, len - 1, n + 1, cur + "0.", result);
                    break;
                case '2':
                    solver(s, idx + 1, len - 1, n + 1, cur + "2.", result);
                    if(1 < len){
                        solver(s, idx + 2, len - 2, n + 1, cur + s.substring(idx, idx + 2) + '.', result);
                    }
                    if(2 < len){
                        char ch = s.charAt(idx + 1);
                        if(ch < '5' || (ch == '5' && s.charAt(idx + 2) <= '5'))
                            solver(s, idx + 3, len - 3, n + 1, cur + s.substring(idx, idx + 3) + '.', result);
                    }
                    break;
                default:
                    solver(s, idx + 1, len - 1, n + 1, cur + s.charAt(idx) + '.', result);
                    if(1 < len){
                        solver(s, idx + 2, len - 2, n + 1, cur + s.substring(idx, idx + 2) + '.', result);
                    }
                    if(s.charAt(idx) == '1' && 2 < len){
                        solver(s, idx + 3, len - 3, n + 1, cur + s.substring(idx, idx + 3) + '.', result);
                    }
                    break;
            }
        }
    }
}
