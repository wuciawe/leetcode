package HIndexII;

/**
 * Created by haha on 2015/9/6.
 */
public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;

        int p1 = 0;
        int p2 = len;

        while(p1 < p2){
            int mid = p1 + (p2 - p1) / 2;
            if(citations[mid] >= len - mid){
                p2 = mid;
            }else{
                p1 = mid + 1;
            }
        }

        return len - p1;
    }
}
