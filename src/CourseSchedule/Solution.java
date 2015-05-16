package CourseSchedule;

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

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] flag = new boolean[numCourses];
        boolean[] mask = new boolean[numCourses];
        Node[] nodes = new Node[numCourses];
        for(int i = 0; i < numCourses; ++i)
            nodes[i] = new Node(i);
        for(int i = 0; i < prerequisites.length; ++i)
            nodes[prerequisites[i][0]].pres.add(nodes[prerequisites[i][1]]);
        for(int i = 0; i < numCourses; ++i){
            if(cyclic(flag, mask, nodes[i])) return false;
        }
        return true;
    }

    private boolean cyclic(boolean[] flag, boolean[] mask, Node node){
        if(!flag[node.n]){
            if(mask[node.n]) return true;
            mask[node.n] = true;
            for(Node n : node.pres){
                if(cyclic(flag, mask, n)) return true;
            }
            mask[node.n] = false;
            flag[node.n] = true;
        }
        return false;
    }
}
