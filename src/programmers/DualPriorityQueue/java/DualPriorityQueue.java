package programmers.DualPriorityQueue.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class DualPriorityQueue {
    public static void main(String[] args) {
        DualPriorityQueueSolution sol = new DualPriorityQueueSolution();

        String[] operations = new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int[] expSol = new int[] {0,0};

        int[] realSol = sol.solution(operations);

        System.out.println(Arrays.toString(realSol));
        System.out.println(Arrays.equals(expSol, realSol));
    }
}

class DualPriorityQueueSolution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder());

        for(String op : operations) {
            if(op.startsWith("I")) {
                pq.offer(Integer.parseInt(op.substring(2)));
                rpq.offer(Integer.parseInt(op.substring(2)));
            } else if(op.equals("D 1") && !rpq.isEmpty()) {
                pq.remove(rpq.poll());
            } else if(op.equals("D -1") && !pq.isEmpty()) {
                rpq.remove(pq.poll());
            }
        }

        if(pq.isEmpty() && rpq.isEmpty()){
            return new int[] {0, 0};
        }

        return new int[] {rpq.peek(), pq.peek()};
    }
}