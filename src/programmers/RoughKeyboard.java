package programmers;

import java.util.Arrays;

public class RoughKeyboard {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] keymap = new String[] {"ABACD", "BCEFD"};
        String[] targets = new String[] {"ABCD","AABB"};
        System.out.println(Arrays.toString(sol.solution(keymap, targets)));
    }
}

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        System.out.println(Arrays.toString(keymap));
        System.out.println(Arrays.toString(targets));

        int[] answer = {};
        return answer;
    }
}
