package NextPermutation;

import java.util.Arrays;

/**
 * Created by haha on 2015/4/26.
 */
public class Solution {
    public void nextPermutation(int[] num) {
        for(int i = num.length - 1; i > 0; --i){
            int tmp = num[i - 1];
            if(tmp < num[i]){
                int target = i;
                int j = target;
                for(; j < num.length; ++j){
                    if(num[j] < num[target] && num[j] > tmp){
                        target = j;
                    }
                }
                num[i - 1] = num[target];
                num[target] = tmp;
                Arrays.sort(num, i, num.length);
                return;
            }
        }
        for(int l = 0, r = num.length - 1; l < r; ++l, --r){
            int tmp = num[l];
            num[l] = num[r];
            num[r] = tmp;
        }
        return;
    }
}
