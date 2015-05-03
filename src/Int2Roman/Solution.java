package Int2Roman;

/**
 * Created by haha on 2015/4/12.
 */
public class Solution {
    public String intToRoman(int num) {
        String str="";
        String[] romans ={"I", "V", "X", "L", "C", "D", "M"};
        int cur = 1000;
        int i=6;
        while(cur>0){
            int tmp = num/cur;
            if(tmp <4){
                String si = romans[i];
                while(tmp>0){
                    str+=si;
                    tmp--;
                }
            }else if(tmp == 4){
                str+=romans[i]+romans[i+1];
            }else if(tmp == 9){
                str+=romans[i]+romans[i+2];
            }else{
                String si = romans[i];
                str+=romans[i+1];
                tmp -=5;
                while(tmp>0){
                    str+=si;
                    tmp--;
                }
            }
            num %= cur;
            cur/=10;
            i-=2;
        }
        return str;
    }
}
