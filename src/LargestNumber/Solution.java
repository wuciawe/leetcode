package LargestNumber;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by haha on 2015/4/28.
 */
public class Solution {
    public String largestNumber(int[] nums) {
        Node[] d = new Node[nums.length];
        for(int i = 0; i < nums.length; ++i){
            d[i] = new Node(nums[i]);
        }
        Arrays.sort(d);
        if(d[0].nb == 0) return "0";
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < nums.length; ++i)
            result.append(d[i].nb);
        return result.toString();
    }


    class Node implements Comparable<Node>{

        public int[] data;
        public int len;
        public int nb;
        Node(int num){
            nb = num;
            len = 1;
            int n = num;
            while(n > 9){
                ++len;
                n /= 10;
            }
            data = new int[len];
            n = len;
            while(num > 9){
                data[--n] = num % 10;
                num /= 10;
            }
            data[--n] = num;
        }

        @Override
        public int compareTo(Node o) {
            int i = 0;
            int minlen = this.len < o.len ? this.len : o.len;
            for(; i < minlen; ++i){
                int cmp = this.data[i] - o.data[i];
                if(cmp > 0) return -1;
                if(cmp < 0) return 1;
            }
            if(this.len < o.len){
                int j = 0;
                for(; i < o.len; ++i, ++j){
                    int cmp = o.data[j] - o.data[i];
                    if(cmp > 0) return -1;
                    if(cmp < 0) return 1;
                }
                i = 0;
                for(; j < o.len; ++j, ++i){
                    int cmp = o.data[j] - this.data[i];
                    if(cmp > 0) return -1;
                    if(cmp < 0) return 1;
                }
            }
            if(this.len > o.len){
                int j = 0;
                for(; i < this.len; ++i, ++j){
                    int cmp = this.data[i] - this.data[j];
                    if(cmp > 0) return -1;
                    if(cmp < 0) return 1;
                }
                i = 0;
                for(; j < this.len; ++j, ++i){
                    int cmp = o.data[i] - this.data[j];
                    if(cmp > 0) return -1;
                    if(cmp < 0) return 1;
                }
            }
            return 0;
        }
    }
}
