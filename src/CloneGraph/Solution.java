package CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by haha on 2015/4/12.
 */
public class Solution {
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        if(map.containsKey(node.label)) return map.get(node.label);
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        map.put(node.label, result);
        for(UndirectedGraphNode n : node.neighbors)
            result.neighbors.add(cloneGraph(n));
        return result;
    }
}
class UndirectedGraphNode {
         int label;
         List<UndirectedGraphNode> neighbors;
         UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
     };