package CompareVersionNumbers;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] tmp = version2.split("\\.");
        String[] v2 = tmp;
        boolean flag = true;
        if(v1.length > tmp.length){
            v2 = v1;
            v1 = tmp;
            flag = false;
        }

        int i = 0;
        for(; i < v1.length; ++i){
            int n1 = Integer.parseInt(v1[i]);
            int n2 = Integer.parseInt(v2[i]);

            if(n1 != n2){
                if(flag){
                    return n1 < n2 ? -1 : 1;
                }else{
                    return n1 < n2 ? 1 : -1;
                }
            }
        }
        for(; i < v2.length; ++i){
            if(Integer.parseInt(v2[i]) != 0){
                if(flag){
                    return -1;
                }else{
                    return 1;
                }
            }
        }
        return 0;
    }
}
