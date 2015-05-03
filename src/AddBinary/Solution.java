package AddBinary;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public String addBinary(String a, String b) {
        String res = "";

        String longer, shorter;
        if(a.length() > b.length()){
            longer = a;
            shorter = b;
        }else{
            longer = b;
            shorter = a;
        }

        int bias = 2 * '0';
        int r = 0;
        int lens = shorter.length();
        int lenl = longer.length();
        for(int i = 1; i <= lens; ++i){
            r += shorter.charAt(lens - i) + longer.charAt(lenl - i) - bias;
            switch (r){
                case 3:
                    res = "1" + res;
                    r = 1;
                    break;
                case 2:
                    res = "0" + res;
                    r = 1;
                    break;
                default:
                    res = Integer.toString(r) + res;
                    r = 0;
                    break;
            }
        }
        bias = '0';
        for(int i = lenl - lens - 1; i >= 0; --i){
            r += longer.charAt(i) - bias;
            switch (r){
                case 2:
                    res = "0" + res;
                    r = 1;
                    break;
                default:
                    res = Integer.toString(r) + res;
                    r = 0;
                    break;
            }
        }

        return r == 1 ? "1" + res : res;
    }
}
