package programmers.RoughKeyboard.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RoughKeyboard {
    public static void main(String[] args) {
        Solution sol = new Solution();

//        String[] keymap = new String[] {"ABACD", "BCEFD"};
//        String[] targets = new String[] {"ABCD","AABB"};

//        String[] keymap = new String[] {"AA"};
//        String[] targets = new String[] {"B"};

        String[] keymap = new String[] {"AGZ", "BSSS"};
        String[] targets = new String[] {"ASA","BGZ"};

        System.out.println(Arrays.toString(sol.solution(keymap, targets)));
    }
}

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<String, Integer> map = new HashMap<>();

        setMap(keymap, map);

        solveAnswer(targets, answer, map);

        return answer;
    }

    private static void solveAnswer(String[] targets, int[] answer, Map<String, Integer> map) {
        for(int i = 0; i< targets.length; i++)  {
            String[] targetList = targets[i].split("");
            int ans = (Integer) 0;
            for(String target : targetList) {
                Integer tmpAns = map.getOrDefault(target, -1);
                if(tmpAns == -1) {
                    ans = -1;
                    break;
                }
                ans+=tmpAns;
            }
            answer[i] = ans;
        }
    }

    private static void setMap(String[] keymap, Map<String, Integer> map) {
        for(String key: keymap) {
            String[] keyList = key.split("");
            for(int i=0; i<keyList.length; i++) {
                Integer value = map.getOrDefault(keyList[i], 0);
                if(value == 0) {
                    map.put(keyList[i], i+1);
                }

                if((value != 0) && value>i+1) {
                    map.put(keyList[i], i+1);
                }
            }
        }
    }
}
