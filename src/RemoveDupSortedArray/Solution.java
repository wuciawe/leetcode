package RemoveDuplicatesSortedArray;

/**
 * Created by haha on 2015/4/24.
 */
public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length < 2) return A.length;
        int n = 0;
        for(int i = 1; i < A.length; ++i){
            if(A[i] != A[n]){
                A[++n] = A[i];
            }
        }
        return n + 1;
    }
}
