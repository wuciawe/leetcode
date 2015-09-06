package HIndex;

/**
 * Created by haha on 2015/9/6.
 */
public class Solution {
    public int hIndex(int[] citations) {
        int[] c = new int[citations.length + 1];
        for(int cs : citations){
            if(cs > citations.length) ++c[citations.length];
            else ++c[cs];
        }
        int total = 0;
        for(int i = citations.length; i >= 0; --i){
            total += c[i];
            if(total >= i) return i;
        }
        return 0;
    }
}
