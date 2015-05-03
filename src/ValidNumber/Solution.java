package ValidNumber;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public boolean isNumber(String s) {
        int i = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            if(ch == ' ' || ch == '\t'){
                ++i;
            }else{
                break;
            }
        }
        if(i == s.length()) return false;
        boolean getE = false;
        boolean getDot = false;
        boolean getNum = false;
        char ch = s.charAt(i);
        if(ch >= '0' && ch <= '9'){
            getNum = true;
        }else if(ch == '.'){
            getDot = true;
        }else if(ch != '-' && ch != '+'){
            return false;
        }
        for(++i; i < s.length(); ++i){
            ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                getNum = true;
            }else if(ch == '.'){
                if(getDot || getE) return false;
                getDot = true;
            }else if(ch == 'e' || ch == 'E'){
                if(getE || !getNum) return false;
                getE = true;
                getNum = false;
            }else if(ch == '+' || ch == '-'){
                if(s.charAt(i - 1) != 'E' && s.charAt(i - 1) != 'e') return false;
            }else if(ch == ' ' || ch == '\t'){
                for(++i; i < s.length(); ++i){
                    ch = s.charAt(i);
                    if(ch != ' ' && ch != '\t') return false;
                }
            }else{
                return false;
            }
        }
        return getNum;
    }
}
