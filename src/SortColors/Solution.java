package SortColors;

/**
 * Created by haha on 2015/4/30.
 */
public class Solution {
    public void sortColors(int[] A) {
        int l = 0;
        int r = A.length - 1;
        int i = 0;
        while(i <= r){
            if(A[i] == 0){
                if(l == i){
                    ++l;
                    ++i;
                }else{
                    A[i] = A[l];
                    A[l++] = 0;
                }
            }else if(A[i] == 2){
                if(r == i){
                    break;
                }else{
                    A[i] = A[r];
                    A[r--] = 2;
                }
            }else{
                ++i;
            }
        }
    }
}
