package SubstringConcatAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by haha on 2015/4/26.
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();

        HashMap<String, Integer> book = new HashMap<String, Integer>();
        for(String word : words){
            if(book.containsKey(word)){
                book.replace(word, book.get(word) + 1);
            }else{
                book.put(word, 1);
            }
        }
        HashMap<String, Integer> tb = new HashMap<String, Integer>(book);

        int len = words[0].length();
        for(int i = 0; i <= s.length() - len * words.length; ++i){
            if(tb.size() != words.length){
                tb = new HashMap<String, Integer>(book);
            }

            int j = i;
            while(!tb.isEmpty()){
                String substr = s.substring(j, j + len);
                if(tb.containsKey(substr)){
                    j += len;
                    int n = tb.get(substr);
                    if(1 == n){
                        tb.remove(substr);
                    }else{
                        tb.replace(substr, n - 1);
                    }
                }else{
                    break;
                }
            }

            if(tb.isEmpty()){
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findSubstring("acaacc", new String[]{"ca","ac"});
    }
}
