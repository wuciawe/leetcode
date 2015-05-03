package MultiplyStrings;

/**
 * Created by haha on 2015/4/26.
 */
public class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        String result = "0";
        for(int i = 0; i < num1.length(); ++i){
            String prod = prod(num2, num1.charAt(num1.length() - i - 1) - '0');
            int a = i;
            while(a > 0){
                --a;
                prod = prod + "0";
            }
            if(result.length() < prod.length()){
                result = add(result, prod);
            }else{
                result = add(prod, result);
            }
        }
        return result;
    }

    private String prod(String s, int n){
        String result = "";
        int r = 0;
        for(int i = s.length() - 1; i >= 0; --i){
            int mp = (s.charAt(i) - '0') * n + r;
            if(mp > 9){
                result = Integer.toString(mp % 10) + result;
                r = mp / 10;
            }else{
                result = Integer.toString(mp) + result;
                r = 0;
            }
        }
        return r > 0 ? Integer.toString(r) + result : result;
    }

    private String add(String s1, String s2){
        int slen = s1.length();
        int llen = s2.length();
        String result = "";
        int i = 0;
        int r = 0;
        for(; i < slen; ++i){
            int s = s1.charAt(s1.length() - i - 1) - '0' + s2.charAt(s2.length() - i - 1) - '0' + r;
            if(s > 9){
                result = Integer.toString(s - 10) + result;
                r = 1;
            }else{
                result = Integer.toString(s) + result;
                r = 0;
            }
        }
        for(; i < llen; ++i){
            int s = s2.charAt(s2.length() - 1 - i) - '0' + r;
            if(s > 9){
                result = Integer.toString(s - 10) + result;
                r = 1;
            }else{
                result = Integer.toString(s) + result;
                r = 0;
            }
        }
        return r > 0 ? "1" + result : result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.multiply("999", "999"));
        System.out.println(123 * 4560);
    }
}
