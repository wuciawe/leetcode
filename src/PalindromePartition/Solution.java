package PalindromePartition;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haha on 2015/4/11.
 */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<List<String>>();
        solve(s, result, new LinkedList<String>(), 0, s.length() - 1);
        return result;
    }

    private void solve(String s, List<List<String>> result, List<String> cur, int l, int r){
        List<Integer> indices = findPalindrome(s, l, r);
        for(Integer index : indices){
            List<String> ncur = pList(cur, s.substring(l, index + 1));
            if(index == r) {
                result.add(ncur);
            }else{
                solve(s, result, ncur, index + 1, r);
            }
        }
    }

    private List<String> pList(List<String> list, String s){
        List<String> result = new LinkedList<String>();
        for(String e : list)
            result.add(e);
        result.add(s);
        return result;
    }

    private List<Integer> findPalindrome(String s, int l, int r){
        List<Integer> result = new LinkedList<Integer>();
        for(int i = r; i > l; --i){
            if(isPalindrome(s, l, i)) result.add(i);
        }
        result.add(l);
        return result;
    }

    private boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        Solution sol = new Solution();
        sol.partition(s);
    }
}
