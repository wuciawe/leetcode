package TextJustification;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.LeafPropertyLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        int len = words.length;
        if(len == 0) return res;

        List<String> l = new ArrayList<String>();
        int cnt = 0;

        for(String word: words){
            int wlen = word.length();
            if(cnt == 0){
                l.add(word);
                cnt += wlen;
            }else if(cnt + wlen + 1 <= maxWidth){
                l.add(word);
                cnt += wlen + 1;
            }else{
                res.add(padWords(l, cnt, maxWidth));
                l.clear();
                l.add(word);
                cnt = wlen;
            }
        }
        if(!l.isEmpty()){
            String space = "";
            for(int i = maxWidth - cnt; i > 0; --i){
                space += " ";
            }
            res.add(padWords(l, cnt, cnt) + space);
        }

        return res;
    }

    private String padWords(List<String> l, int cnt, int maxWidth){
        StringBuilder res = new StringBuilder();

        int remain = maxWidth - cnt;
        int n = l.size() - 1;
        if(n == 0){
            res.append(l.get(0));
            while(remain-- > 0){
                res.append(' ');
            }
            return res.toString();
        }
        int m = remain / n;
        int r = remain % n;

        String lessPad = "";
        for(int i = m + 1; i > 0; --i){
            lessPad += " ";
        }
        String morePad = lessPad + " ";
        if(remain == 0) morePad = lessPad;

        int i = 0;
        for(; i < r; ++i){
            res.append(l.get(i));
            res.append(morePad);
        }
        for(; i < n; ++i){
            res.append(l.get(i));
            res.append(lessPad);
        }
        res.append(l.get(n));
        return res.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.fullJustify(new String[]{"a","b","c","d","e"}, 3);
    }
}
