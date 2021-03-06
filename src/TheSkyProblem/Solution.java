package TheSkyProblem;

import java.util.*;

/**
 * Created by haha on 2015/6/8.
 */
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        if(buildings == null || buildings.length == 0) {
            return Collections.emptyList();
        }

        final PriorityQueue<Building> endings = new PriorityQueue<>((v1, v2) -> Integer.compare(v1.to, v2.to));
        final PriorityQueue<Integer> heights = new PriorityQueue<>((v1, v2) -> Integer.compare(v2, v1));

        final List<int[]> result = new ArrayList<>();

        // iterate over each of the building
        for(int[] build : buildings) {
            final Building building = new Building(build);

            while (endings.size() > 0 && endings.peek().to < building.from) { // all the buildings end before current one need to be taken care of
                removeBuildings(endings, heights, result);
            }

            if(heights.size() == 0 || building.height > heights.peek()) { // left most edge
                result.add(new int[]{building.from, building.height});
            }
            heights.add(building.height);
            endings.add(building);
        }

        while(endings.size() > 0) { // remaining ones
            removeBuildings(endings, heights, result);
        }

        return result;
    }

    private void removeBuildings(PriorityQueue<Building> endings, PriorityQueue<Integer> heights, List<int[]> result) {
        final Building rm = endings.poll(); // this is the left most ending building
        heights.remove(rm.height);
        while(endings.size() > 0 && endings.peek().to == rm.to) { // remove all the buildings end at the same place as rm
            heights.remove(endings.poll().height);
        }
        final int peek = heights.size() > 0 ? heights.peek() : 0; // remaining buildings' top height
        if(peek < rm.height) {
            result.add(new int[]{rm.to, peek});
        }
    }

    private static class Building {
        private final int from;
        private final int to;
        private final int height;

        public Building(int[] building) {
            this.from = building[0];
            this.to = building[1];
            this.height = building[2];
        }
    }
}