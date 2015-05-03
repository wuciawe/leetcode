package MedianTwoSortedArrays;

/**
 * Created by jwhu on 4/16/15.
 */
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]){
        int len = A.length + B.length;
        if(len % 2 == 1){
            return k(A, 0, A.length, B, 0, B.length, len / 2 + 1);
        }else{
            return 0.5 * (k(A, 0, A.length, B, 0, B.length, len / 2) + k(A, 0, A.length, B, 0, B.length, len / 2 + 1));
        }
    }

    private int k(int A[], int la, int ra, int B[], int lb, int rb, int k){
        if(ra - la < rb - lb) return k(B, lb, rb, A, la, ra, k);
        if(rb - lb == 0) return A[la + k - 1];
        if(k == 1) return Math.min(A[la], B[lb]);

        int sb = Math.min(rb - lb, k / 2);
        int sa = k - sb;

        if(A[la + sa - 1] < B[lb + sb - 1]) return k(A, la + sa, ra, B, lb, rb, k - sa);
        return k(A, la, ra, B, lb + sb, rb, k - sb);
    }
}
