package RemoveElement;

/**
 * Created by haha on 2015/4/25.
 */
public class Solution {
    public int removeElement(int[] A, int elem) {
        int idx = 0;
        for(int i = 0; i < A.length; ++i){
            if(A[i] != elem){
                A[idx++] = A[i];
            }
        }
        return idx;
    }
}
