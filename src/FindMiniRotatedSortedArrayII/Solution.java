package FindMiniRotatedSortedArrayII;

/**
 * Created by haha on 2015/4/12.
 */
public class Solution {
    public int findMin(int[] num) {
        int lo = 0;
        int hi = num.length - 1;
        int mid = 0;

        while(lo < hi) {
            mid = lo + (hi - lo) / 2;

            if (num[mid] > num[hi]) {
                lo = mid + 1;
            }
            else if (num[mid] < num[hi]) {
                hi = mid;
            }
            else { // when num[mid] and num[hi] are same
                --hi;
            }
        }
        return num[lo];
    }

//    private static void find(int[] a, int lo, int hi) {
//        if (hi <= lo) return;
//        int lt = lo, gt = hi;
//        int v = a[lo];
//        int i = lo;
//        while (i <= gt) {
//            int cmp = a[i] - v;
//            if (cmp < 0) exch(a, lt++, i++);
//            else if (cmp > 0) exch(a, i, gt--);
//            else i++;
//        }
//        if (lt == 0) return;
//        find(a, lo, lt - 1);
//        find(a, gt + 1, hi);
//    }
//
//    private static void exch(int[] a, int i, int j) {
//        int swap = a[i];
//        a[i] = a[j];
//        a[j] = swap;
//    }
}
