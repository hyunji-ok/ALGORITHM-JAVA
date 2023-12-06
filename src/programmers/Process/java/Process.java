package programmers.Process.java;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.stream.IntStream;

public class Process {
    public static void main(String[] args) {
        ProcessSolution sol = new ProcessSolution();

//        int[] priorities = {2, 1, 3, 2};
//        int location = 2;

//        int[] priorities = {1, 1, 9, 1, 1, 1};
//        int location = 0;

        int[] priorities = {1,2,3,4,5};
        int location = 2;

//        int[] priorities = {5, 4, 3, 2, 1};
//        int location = 4;

        System.out.println(sol.solution(priorities, location));
    }
}

class ProcessSolution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> prioritieQueue = IntStream.of(priorities)
                .boxed() // int를 Integer로 박싱
                .collect(ArrayDeque::new, Queue::offer, Queue::addAll);
        int max = Collections.max(prioritieQueue);
        int tmp = 0;

        while(location >=0) {
            tmp = prioritieQueue.poll();
            location--;
            if(tmp == max) {
                answer++;
                if(!prioritieQueue.isEmpty()) max = Collections.max(prioritieQueue);
            } else {
                prioritieQueue.offer(tmp);
                if(location<0){
                    location += prioritieQueue.size();
                }
            }
        }

        return answer;
    }
}
