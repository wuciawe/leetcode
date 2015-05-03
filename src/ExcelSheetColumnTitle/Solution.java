package ExcelSheetColumnTitle;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public String convertToTitle(int n) {
        return solver(n - 1);
    }

    private String solver(int n){
        return n == -1 ? "" : solver(n / 26 - 1) + (char)('A' + n % 26);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.convertToTitle(27));
    }
}
