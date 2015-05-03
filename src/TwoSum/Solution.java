package TwoSum;

import java.util.Arrays;

/**
 * Created by jwhu on 4/16/15.
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target){
        int[] sorted = new int[numbers.length];
        for(int i = 0; i < numbers.length; ++i){
            sorted[i] = numbers[i];
        }
        Arrays.sort(sorted);
        for(int i = 0; i < numbers.length; ++i){
            int one = sorted[i];
            if(one > target && one >= 0) continue;
            for(int j = i + 1; j < numbers.length; ++j){
                int two = sorted[j];
                int sum = one + two;
                if(sum > target){
                    break;
                }else if(sum == target){
                    for(int ii = 0; ii < numbers.length; ++ii){
                        if(numbers[ii] == one){
                            for(int jj = ii + 1; jj < numbers.length; ++jj){
                                if(numbers[jj] == two) return new int[] {ii + 1, jj + 1};
                            }
                        }else if(numbers[ii] == two){
                            for(int jj = ii + 1; jj < numbers.length; ++jj){
                                if(numbers[jj] == one) return new int[] {ii + 1, jj + 1};
                            }
                        }
                    }
                }
            }
        }
        return new int[]{0,0};
    }
}
