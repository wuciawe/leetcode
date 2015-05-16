package CourseScheduleII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haha on 2015/5/16.
 */
public class Solution {
    private class Node{
        int n;
        List<Node> pres = new ArrayList<Node>();
        Node(int n){
            this.n = n;
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] flag = new boolean[numCourses];
        boolean[] mask = new boolean[numCourses];
        Node[] nodes = new Node[numCourses];
        for(int i = 0; i < numCourses; ++i)
            nodes[i] = new Node(i);
        for (int[] prerequisite : prerequisites) nodes[prerequisite[0]].pres.add(nodes[prerequisite[1]]);
        int[] res = new int[numCourses];
        int idx = 0;
        for(int i = 0; i < numCourses; ++i){
            int nidx = cyclic(idx, res, flag, mask, nodes[i]);
            if(nidx == -1) return new int[0];
            if(nidx >= 0){
                idx = nidx;
                res[idx++] = nodes[i].n;
            }
        }
        return res;
    }

    private int cyclic(int idx, int[] res, boolean[] flag, boolean[] mask, Node node){
        if(!flag[node.n]){
            if(mask[node.n]) return -1;
            mask[node.n] = true;
            for(Node n : node.pres){
                int nidx = cyclic(idx, res, flag, mask, n);
                if(nidx == -1) return -1;
                if(nidx >= 0){
                    idx = nidx;
                    res[idx++] = n.n;
                }
            }
            mask[node.n] = false;
            flag[node.n] = true;
            return idx;
        }else{
            return -2;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] pre = new int[4][];
        pre[0] = new int[]{1, 0};
        pre[1] = new int[]{2, 0};
        pre[2] = new int[]{3, 1};
        pre[3] = new int[]{3, 2};
        int[] res = sol.findOrder(4, pre);
        if(res[0] == 0){

        }
    }
}
