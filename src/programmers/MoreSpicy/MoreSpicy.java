package programmers.MoreSpicy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MoreSpicy {
    public static void main(String[] args) {
        MoreSpicySolution sol = new MoreSpicySolution();

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int answer = 2;

        int realSol = sol.solution(scoville, K);
        System.out.println(realSol);
        System.out.println(realSol == answer);
    }
}

class MoreSpicySolution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = Arrays.stream(scoville).boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));
        int answer = 0;
        int tmp1;
        int tmp2;

        while(!(pq.size() == 1 || pq.peek() >= K)) {
            tmp1 = pq.poll();
            tmp2 = pq.poll();
            pq.offer(tmp1 + (tmp2 * 2));

            answer++;
        }

        int peek = pq.peek();
        return peek >= K ? answer : -1;
    }
}