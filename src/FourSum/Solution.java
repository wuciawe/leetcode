package FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by haha on 2015/4/24.
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num.length < 4) return result;
        HashSet<List<Integer>> cache = new HashSet<List<Integer>>();

        Arrays.sort(num);
        for(int a = 0; a < num.length; ++a){
            for(int d = num.length - 1; d > a + 2; --d){
                int b = a + 1;
                int c = d - 1;
                while(b < c){
                    int cmp = num[a] + num[b] + num[c] + num[d] - target;
                    if(cmp == 0){
                        List<Integer> r = new ArrayList<Integer>();
                        r.add(num[a]);
                        r.add(num[b]);
                        r.add(num[c]);
                        r.add(num[d]);
                        if(cache.add(r))
                            result.add(r);
                        --c;
                        ++b;
                    }else if(cmp > 0){
                        --c;
                    }else{
                        ++b;
                    }
                }
            }
        }

        return result;
    }
}
