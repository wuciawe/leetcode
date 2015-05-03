package ExcelSheetColNum;

/**
 * Created by jwhu on 4/16/15.
 */
public class Solution {
    public int titleToNumber(String s) {
        if(s == null || s.equals("")) return 0;
        int b = 'A' - 1;
        int result = s.charAt(s.length() - 1) - b;
        int base = 1;
        for(int i = s.length() - 2; i >= 0; --i){
            base *= 26;
            result += base * (s.charAt(i) - b);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.titleToNumber("Z"));
        System.out.println(sol.titleToNumber("AB"));
    }
}
