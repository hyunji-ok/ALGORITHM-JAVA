package programmers.Ponkemon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ponkemon {

    public static void main(String[] args) {
        PonkemonSolution sol = new PonkemonSolution();

//        int[] nums = new int[] {3,1,2,3};
//        int[] nums = new int[] {3,3,3,2,2,4};
        int[] nums = new int[] {3,3,3,2,2,2};

        System.out.println(sol.solution(nums));
    }

}

class PonkemonSolution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        // map setting
        Arrays.stream(nums).forEach(i-> map.putIfAbsent(i, 1));

        return Math.min(map.size(), nums.length / 2);
    }
}
