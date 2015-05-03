package GasStation;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int start = 0; start < gas.length;){
            int remain = 0;
            int i = 0;
            for(; i < gas.length; ++i){
                int pos = (start + i) % gas.length;
                remain = remain + gas[pos] - cost[pos];
                if(remain < 0) break;
            }
            if(i == gas.length) return start;
            start = start + i + 1;
        }
        return -1;
    }
}
