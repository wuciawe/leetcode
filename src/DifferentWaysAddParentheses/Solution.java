package DifferentWaysAddParentheses;

import java.util.*;

/**
 * Created by haha on 2015/9/6.
 */
public class Solution {

    static private Map<String, List<Integer>> cache = new HashMap<>();
    static private Set<Character> operators = new HashSet<>();
    static {
        operators.add('+');
        operators.add('-');
        operators.add('*');
    }

    public List<Integer> diffWaysToCompute(String input) {
        if(cache.containsKey(input)) return cache.get(input);

        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < input.length(); ++i){
            char c = input.charAt(i);
            if(operators.contains(c)){
                List<Integer> lefts = diffWaysToCompute(input.substring(0, i));
                List<Integer> rights = diffWaysToCompute(input.substring(i + 1));
                for(int left : lefts){
                    for(int right : rights){
                        switch (c) {
                            case '+':
                                ret.add(left + right);
                                break;
                            case '-':
                                ret.add(left - right);
                                break;
                            case '*':
                                ret.add(left * right);
                                break;
                        }
                    }
                }
            }
        }
        if(ret.isEmpty()) ret.add(Integer.valueOf(input));
        cache.put(input, ret);
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.diffWaysToCompute("1+2+3"));
    }
}
