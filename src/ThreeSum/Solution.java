package ThreeSum;

import java.util.*;

/**
 * Created by haha on 2015/4/24.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> cache = new HashSet<List<Integer>>();

        Arrays.sort(num);

        for(int a = 0; a < num.length; ++a){
            for(int b = a + 1, c = num.length - 1; b < c;){
                int sum = num[a] + num[b] + num[c];
                if(sum == 0){
                    List<Integer> r = new ArrayList<Integer>();
                    r.add(num[a]);
                    r.add(num[b]);
                    r.add(num[c]);
                    if(cache.add(r))
                        res.add(r);
                    ++b;
                    --c;
                }else if(sum > 0){
                    --c;
                }else{
                    ++b;
                }
            }
        }
        return res;
    }

}
