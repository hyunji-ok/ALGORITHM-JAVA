package programmers.BestAlbum;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BestAlbum {
    public static void main(String[] args) {
        BestAlbumSolution sol = new BestAlbumSolution();

        String[] genres = new String[] {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[] {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(sol.solution(genres, plays)));

    }
}
class BestAlbumSolution {
    public int[] solution(String[] genres, int[] plays) {

        return IntStream.range(0, plays.length)
                .mapToObj(i -> new Music(genres[i], plays[i], i))
                .collect(Collectors.groupingBy(Music::getGenre))
                .entrySet().stream()
                .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
                .flatMap(i -> i.getValue().stream().sorted().limit(2))
                .mapToInt(Music::getNum)
                .toArray();
    }

    private int sum(List<Music> value) {
        int answer = 0;
        for(Music val : value){
            answer+= val.getPlay();
        }
        return answer;
    }
}

class Music implements Comparable<Music> {

    private final String genre;

    private final Integer play;

    private final Integer num;

    public Music(String genre, Integer play, Integer num) {
        this.genre = genre;
        this.play = play;
        this.num = num;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getPlay() {
        return play;
    }

    public Integer getNum() {
        return num;
    }

    @Override
    public int compareTo(Music o) {
        if(Objects.equals(this.play, o.play)) {
            return this.num - o.num;
        }

        return o.play - this.play;
    }
}