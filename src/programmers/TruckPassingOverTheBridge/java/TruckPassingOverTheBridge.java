package programmers.TruckPassingOverTheBridge.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TruckPassingOverTheBridge {
    public static void main(String[] args) {
        TruckPassingOverTheBridgeSolution sol = new TruckPassingOverTheBridgeSolution();

//        int bridge_length = 2;
//        int weight = 10;
//        int[] truck_weights = {7,4,5,6};
//        int answer = 8;

//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10};
//        int answer = 101;

        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
        int answer = 110;

        int realSol = sol.solution(bridge_length, weight, truck_weights);

        System.out.println(realSol);
        System.out.println(realSol == answer);
    }
}

class TruckPassingOverTheBridgeSolution{
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int bridgeSum = 0;
        int tmp;
        int idx = 0;
        int truckLengh = truck_weights.length;
        Queue<Integer> bridgeQueue = IntStream.range(0, bridge_length)
                .mapToObj(i -> 0).collect(Collectors.toCollection(LinkedList::new));

        while(true){
            time++;
            tmp = bridgeQueue.poll();
            bridgeSum -= tmp;
            if(idx!=truckLengh) {
                if (bridgeSum + truck_weights[idx] <= weight) {
                    bridgeQueue.offer(truck_weights[idx]);
                    bridgeSum += truck_weights[idx];
                    idx++;
                } else {
                    bridgeQueue.offer(0);
                }
            } else {
                bridgeQueue.offer(0);
            }

            if(idx==truckLengh && bridgeSum == 0) break;
        }

        return time;
    }
}
