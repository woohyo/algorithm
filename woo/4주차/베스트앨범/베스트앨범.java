import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresCounter = new HashMap<>();
        Map<String, PriorityQueue<int[]>> songsByGenre = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int playCount = plays[i];
            genresCounter.put(genre, genresCounter.getOrDefault(genre, 0) + playCount);

            songsByGenre.putIfAbsent(genre, new PriorityQueue<>((a, b) -> b[1] - a[1]));
            songsByGenre.get(genre).add(new int[]{i, playCount});
        }
        List<String> sortedGenres = new ArrayList<>(genresCounter.keySet());
        sortedGenres.sort((g1, g2) -> genresCounter.get(g2) - genresCounter.get(g1));

        List<Integer> answerList = new ArrayList<>();
        for (String genre : sortedGenres) {
            PriorityQueue<int[]> queue = songsByGenre.get(genre);
            int count = 0;
            while (!queue.isEmpty() && count < 2) {
                answerList.add(queue.poll()[0]);
                count++;
            }
        }
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}