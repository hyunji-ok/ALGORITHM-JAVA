package programmers.IHateTheSameNumber;

import java.util.Arrays;
import java.util.Stack;

public class IHateTheSameNumber {
    public static void main(String[] args) {
        IHateTheSameNumberSolution sol = new IHateTheSameNumberSolution();

//        int[] arr = new int[] {1,1,3,3,0,1,1};
        int[] arr = new int[] {4,4,4,3,3};

        System.out.println(Arrays.toString(sol.solution(arr)));

    }


}

class IHateTheSameNumberSolution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);

        for(int i=1; i<arr.length; i++) {
            if(arr[i] != stack.peek()){
                stack.push(arr[i]);
            }
        }

        return stack.stream().mapToInt(x->x).toArray();
    }
}
