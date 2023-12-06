package programmers.Costume.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Costume {

    public static void main(String[] args) {
        CostumeSolution sol = new CostumeSolution();

        String[][] clothes = new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
//        String[][] clothes = new String[][] {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        System.out.println(sol.solution(clothes));
    }
}

class CostumeSolution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        Arrays.stream(clothes).forEach(i->{
            if(map.containsKey(i[1])){
                Integer value = map.get(i[1])+1;
                map.put(i[1], value);
            } else {
                map.put(i[1], 1);
            }
        });

        if(map.keySet().size()>1){
            return map.values().stream().reduce(1, (x,y)->(x)*(y+1))-1;
        } else {
            return (Integer) map.values().toArray()[0];
        }
    }

//    public int solution(String[][] clothes) {
//        return Arrays.stream(clothes)
//                .collect(Collectors.groupingBy(p -> p[1], Collectors.mapping(p->p[0], Collectors.counting())))
//                .values()
//                .stream()
////                .peek(System.out::println)
//                .collect(Collectors.reducing(1L, (x,y) -> x*(y+1))).intValue()-1;
//
//    }
}
