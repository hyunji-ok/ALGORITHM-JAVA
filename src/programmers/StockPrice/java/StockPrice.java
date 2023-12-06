package programmers.StockPrice.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StockPrice {
    public static void main(String[] args) {
        StockPriceSolution sol = new StockPriceSolution();

        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = {4, 3, 1, 1, 0};

        int[] realSol = sol.solution(prices);

        System.out.println(Arrays.toString(realSol));
        System.out.println(Arrays.equals(realSol, answer));

    }

}

class StockPriceSolution {
    public int[] solution(int[] prices) {
        Queue<Integer> answerQue = new LinkedList<>();
        int cnt = 0;

        for(int i=0; i< prices.length; i++){
            cnt = 0;
            for(int j=i+1; j< prices.length+1; j++){
                if(j == prices.length) {
                    answerQue.offer(cnt);
                    break;
                }

                cnt++;
                if(prices[i] > prices[j]) {
                    answerQue.offer(cnt);
                    break;
                }
            }
        }

        return answerQue.stream().mapToInt(Integer::intValue).toArray();
    }
}
