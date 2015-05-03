package WordLadderII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by haha on 2015/5/2.
 */
public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<String> cl = new ArrayList<String>();
        cl.add(start);
        List<List<String>> cr = new ArrayList<List<String>>();
        cr.add(new ArrayList<String>(cl));
        List<List<String>> result = new ArrayList<List<String>>();
        if(start.equals(end)){
            result.add(cl);
            return result;
        }
        dict.remove(start);
        dict.add(end);
        while(!cl.isEmpty()){
            List<String> nl = new ArrayList<String>();
            List<List<String>> nr = new ArrayList<List<String>>();
            for(int i = 0; i < cl.size(); ++i){
                String s = cl.get(i);
                List<String> r = cr.get(i);
                StringBuilder sb = new StringBuilder(s);
                for(int j = 0; j < sb.length(); ++j){
                    char c = sb.charAt(j);
                    for(char ch = 'a'; ch <= 'z'; ++ch){
                        if(ch != c){
                            sb.setCharAt(j, ch);
                            String word = sb.toString();
                            if(word.equals(end)){
                                List<String> lr = new ArrayList<String>(r);
                                lr.add(word);
                                result.add(lr);
                            }else if(dict.contains(word)){
                                nl.add(word);
                                List<String> lr = new ArrayList<String>(r);
                                lr.add(word);
                                nr.add(lr);
                            }
                        }
                    }
                    sb.setCharAt(j, c);
                }
            }
            if(!result.isEmpty()) break;
            for(int i = 0; i < nl.size(); ++i){
                dict.remove(nl.get(i));
            }
            cl = nl;
            cr = nr;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] d = new String[]{"ted","tex","red","tax","tad","den","rex","pee"};
        HashSet<String> dict = new HashSet<String>();
        for(String s: d){
            dict.add(s);
        }
        sol.findLadders("red", "tex", dict);
    }
}
