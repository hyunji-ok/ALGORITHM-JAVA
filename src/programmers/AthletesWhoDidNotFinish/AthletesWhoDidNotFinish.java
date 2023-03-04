package programmers.AthletesWhoDidNotFinish;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AthletesWhoDidNotFinish {

    public static void main(String[] args) {
        AthletesWhoDidNotFinishSolution sol = new AthletesWhoDidNotFinishSolution();

        String[] participant = new String[] {"leo", "kiki", "eden"};
        String[] completion = new String[] {"eden", "kiki"};

        System.out.println(sol.solution(participant, completion));
    }
}

class AthletesWhoDidNotFinishSolution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        setParticipant(participant, map);

        deleteCompletionInMap(completion, map);

        return map.keySet().toArray()[0].toString();
    }

    private static void deleteCompletionInMap(String[] completion, Map<String, Integer> map) {
        Arrays.stream(completion).forEach(i->{
            if(map.containsKey(i)){
                Integer value = map.get(i) - 1;
                if(value == 0) {
                    map.remove(i);
                } else {
                    map.put(i,value);
                }
            }
        });
    }

    private static void setParticipant(String[] participant, Map<String, Integer> map) {
        Arrays.stream(participant).forEach(i->{
            if(map.containsKey(i)){
                Integer value = map.get(i) + 1;
                map.put(i,value);
            } else {
                map.put(i,1);
            }
        });
    }
}
