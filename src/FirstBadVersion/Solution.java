package FirstBadVersion;

/**
 * Created by haha on 2015/9/9.
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int p1 = 1;
        int p2 = n; // n + 1
        while(p1 < p2){
            int mid = p1 + (p2 - p1) / 2;
            if(isBadVersion(mid)){
                p2 = mid;
            }else{
                p1 = mid + 1;
            }
        }
        return p1;
    }
}

class VersionControl {
    boolean isBadVersion(int version) {
        return version > 0;
    }
}