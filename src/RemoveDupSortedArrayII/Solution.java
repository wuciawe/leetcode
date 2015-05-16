package RemoveDuplicatesSortedArrayII;

/**
 * Created by haha on 2015/4/30.
 */
public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length < 3) return A.length;
        int pre = 0;
        for(int i = 1; i < A.length;){
            if(A[i] != A[pre]){
                A[++pre] = A[i++];
            }else{
                A[++pre] = A[i++];
                for(; i < A.length; ++i){
                    if(A[i] != A[pre]) break;
                }
            }
        }
        return pre + 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.removeDuplicates(new int[]{1,1,2});
    }
}
