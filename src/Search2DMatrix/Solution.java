package Search2DMatrix;

/**
 * Created by haha on 2015/4/30.
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int hlen = matrix.length;
        if(hlen == 0) return false;
        int wlen = matrix[0].length;
        if(wlen == 0) return false;

        int h = getHeight(matrix, target, hlen, wlen);

        if(h < hlen){
            return exists(matrix[h], target, wlen);
        }

        return false;
    }

    private int getHeight(int[][] matrix, int target, int hlen, int wlen){
        int l = 0;
        int r = hlen - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(matrix[mid][0] > target){
                r = mid - 1;
            }else if(matrix[mid][wlen - 1] < target){
                l = mid + 1;
            }else{
                return mid;
            }
        }
        if(l == r && matrix[l][0] <= target && matrix[l][wlen - 1] >= target) return l;
        else return hlen;
    }

    private boolean exists(int[] arr, int target, int len){
        int l = 0;
        int r = len - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            int M = arr[mid];
            if(M == target) return true;
            else if(M > target) r = mid - 1;
            else l = mid + 1;
        }
        return l == r && arr[l] == target;
    }
}
