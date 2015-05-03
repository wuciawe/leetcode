package FirstMissingPositive;

/**
 * Created by haha on 2015/4/26.
 */
public class Solution {
    public int firstMissingPositive(int[] A) {
        for(int i = 0; i < A.length; ++i){
            int r = A[i];
            if(r > 0 && r <= A.length && r != A[r - 1]){
                int tmp = A[r - 1];
                A[r - 1] = r;
                A[i] = tmp;
                --i;
            }
        }
        for(int i = 0; i < A.length; ++i){
            if(i != A[i] - 1) return i + 1;
        }
        return A.length + 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.firstMissingPositive(new int[]{3,4,-1,1});
    }
}
