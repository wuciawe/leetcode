package String2Integer;

/**
 * Created by haha on 2015/4/12.
 */
public class Solution {
    public int atoi(String str) {
        int result = 0;
        boolean isBegin = false;
        boolean isPos = true;
        int idx = 0;
        while(idx < str.length()){
            char c = str.charAt(idx);
            if(isBegin){
                if(c >= '0' && c <= '9'){
                    int n = c - '0';
                    if(result < 214748364){
                        result *= 10;
                        result += n;
                    }else if(result == 214748364){
                        if(n <= 7){
                            result *= 10;
                            result += n;
                            if(isPos) return result;
                            else return -result;
                        }else if(!isPos && n == 8){
                            return -2147483648;
                        }else{
                            if(isPos) return 2147483647;
                            else return -2147483648;
                        }
                    } else {
                        if(isPos) return 2147483647;
                        else return -2147483648;
                    }
                }else{
                    break;
                }
            }else{
                if(c == '-'){
                    isBegin = true;
                    isPos = false;
                }else if(c == '+'){
                    isBegin = true;
                }else if(c >= '0' && c <= '9'){
                    isBegin = true;
                    result += (c - '0');
                }else if(c != ' ' && c != '\t'){
                    break;
                }
            }
            ++idx;
        }
        if(isPos)return result;
        else return -result;
    }
}
