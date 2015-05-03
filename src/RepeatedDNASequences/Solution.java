package RepeatedDNASequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by haha on 2015/4/28.
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int[] charset = new int[200];
        charset['A'] = 0;
        charset['C'] = 1;
        charset['G'] = 2;
        charset['T'] = 3;
        HashSet<String> result = new HashSet<String>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = s.length() - 10; i >= 0; --i){
            String str = s.substring(i, i + 10);
            int code = 0;
            for(int j = 0; j < 10; ++j){
                code = 4 * code + charset[str.charAt(j)];
            }
            if(set.contains(code)){
                result.add(str);
            }else{
                set.add(code);
            }
        }
        return new ArrayList<String>(result);
    }
}
