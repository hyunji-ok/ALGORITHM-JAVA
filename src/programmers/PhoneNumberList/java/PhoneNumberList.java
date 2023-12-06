package programmers.PhoneNumberList.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumberList {
    public static void main(String[] args) {
//        String[] phone_book = new String[] {"119", "97674223", "1195524421"};
//        String[] phone_book = new String[] {"123","456","789"};
        String[] phone_book = new String[] {"12","123","1235","567","88"};

        PhoneNumberListSolution sol = new PhoneNumberListSolution();

        System.out.println(sol.solution(phone_book));
    }


}

class PhoneNumberListSolution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();

        Arrays.stream(phone_book).forEach(i -> map.put(i, 1));

        for (String s : phone_book) {
            for (int j = 0; j < s.length(); j++) {
                if (map.containsKey(s.substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }
}
