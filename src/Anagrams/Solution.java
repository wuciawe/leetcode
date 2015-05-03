package Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    private static final long[] PRIMES;

    static{
        PRIMES = new long[126];
        long[] tmp = new long[]{2, 3, 5, 7, 11 ,13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 107};
        int i = 0;
        for(char c = 'a'; c <= 'z'; ++c){
            PRIMES[c] = tmp[i++];
        }
    }

    public List<String> anagrams(String[] strs) {
        HashMap<Long, List<String>> map = new HashMap<Long, List<String>>();
        for(String s : strs){
            long mp = 1;
            for(int i = 0; i < s.length(); ++i){
                mp *= PRIMES[s.charAt(i)];
            }
            if(map.containsKey(mp)){
                map.get(mp).add(s);
            }else{
                List<String> l = new ArrayList<String>();
                l.add(s);
                map.put(mp, l);
            }
        }
        List<String> result = new ArrayList<String>();
        for(List<String> l : map.values()){
            if(l.size() > 1){
                result.addAll(l);
            }
        }
        return result;
    }
}
