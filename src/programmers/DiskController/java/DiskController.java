package programmers.DiskController.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController {
    public static void main(String[] args) {
        DiskControllerSolution sol = new DiskControllerSolution();

//        int[][] jobs = new int[][]{{0, 3}, {1, 9}, {2, 6}};
//        int expSol = 9;

        int[][] jobs = new int[][]{{0, 10}, {4, 10}, {5, 11}, {15, 2}};
        int expSol = 15;

        int realSol = sol.solution(jobs);

        System.out.println(realSol);
        System.out.println(realSol==expSol);
    }
}

class DiskControllerSolution {
    public int solution(int[][] jobs) {
        int end = 0;
        int jobIdx = 0;
        int finishIdx = 0;
        int sum = 0;
        int[] poll;

        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        while(true) {
            if(finishIdx == jobs.length) break;

            while(jobIdx < jobs.length && jobs[jobIdx][0] <= end) {
                pq.offer(jobs[jobIdx]);
                jobIdx++;
            }

            if(!pq.isEmpty()){
                poll = pq.poll();
                end += poll[1];
                sum += end - poll[0];
                finishIdx++;
            } else {
                end = jobs[jobIdx][0];
            }

        }

        return sum/ jobs.length;
    }
}