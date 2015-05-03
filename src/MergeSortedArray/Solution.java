package MergeSortedArray;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int mn = m + n - 1;
        int ia = m - 1;
        int ib = n - 1;

        while(ia >= 0 && ib >= 0){
            int a = A[ia];
            int b = B[ib];
            if(a > b){
                A[mn--] = a;
                --ia;
            }else{
                A[mn--] = b;
                --ib;
            }
        }
        while(ib >= 0){
            A[mn--] = B[ib--];
        }
    }


}
