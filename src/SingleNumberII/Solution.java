package SingleNumberII;

import java.util.HashMap;

/**
 * Created by haha on 2015/4/12.
 */
public class Solution {
    public int singleNumber(int[] A) {
//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//        int i = 0;
//        while(i < A.length){
//            int c = A[i++];
//            if(map.containsKey(c)){
//                int r = map.get(c);
//                if(r == 2) map.remove(c);
//                else map.put(c, r + 1);
//            }else{
//                map.put(c, 1);
//            }
//        }
//        return map.keySet().iterator().next();
        int[] sum_for_bits = new int[32];

        for (int aA : A) {
            for (int j = 0; j < 32; ++j) {
                if ((aA & (1 << j)) != 0) {
                    ++sum_for_bits[j];
                }
            }
        }

        int singlN = 0;
        for(int i = 0; i < 32; ++i){
            if(sum_for_bits[i] % 3 != 0){
                singlN |= (1<<i);
            }
        }
        return singlN;
    }
}
