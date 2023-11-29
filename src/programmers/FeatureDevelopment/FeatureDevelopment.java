package programmers.FeatureDevelopment;

import java.util.*;

public class FeatureDevelopment {
    public static void main(String[] args) {
        FeatureDevelopmentSolution sol = new FeatureDevelopmentSolution();

//        int[] progresses = new int[] {93, 30, 55};
//        int[] speeds = new int[] {1, 30, 5};

        int[] progresses = new int[] {95, 90, 99, 99, 80, 99};
        int[] speeds = new int[] {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(sol.solution(progresses, speeds)));

    }
}

class FeatureDevelopmentSolution {
    public int[] solution(int[] progresses, int[] speeds) {
        int day = 0;
        int idx = 0;
        int cnt = 0;
        Queue<Integer> answerQueue = new LinkedList<>();

        while(idx != progresses.length) {
            int tmp = progresses[idx] + (speeds[idx]*day);
            if(tmp>=100) {
                idx++;
                cnt++;
            } else {
                if(cnt != 0) {
                    answerQueue.offer(cnt);
                    cnt = 0;
                }
                day++;
            }

            if(idx == progresses.length){
                answerQueue.offer(cnt);
            }
        }

        return answerQueue.stream().mapToInt(Integer::intValue).toArray();
    }
}