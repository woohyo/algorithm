import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};

        HashMap<Integer, Double> map = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            int target = i;
            if(!Arrays.stream(stages).anyMatch(x -> x == target)) {
                map.put(i, 0.0);
            }
        }

        for(int stage : stages) {
            if(map.get(stage) != null && stage != N + 1) {
                continue;
            }

            int reached = 0;
            int failed = 0;
            Double failedRate = 0.0;

            for(int i = 0; i < stages.length; i++) {
                if (stages[i] >= stage) {
                    reached += 1;
                }
                if (stages[i] == stage) {
                    failed += 1;
                }
            }
            failedRate = (double) failed / reached;

            if(stage != N + 1) {
                map.put(stage, failedRate);
            }
        } //for

        answer = getSortedKeysByValueDesc(map);
        return answer;
    }

    public static int[] getSortedKeysByValueDesc(HashMap<Integer, Double> map) {
        return map.entrySet().stream()
                .sorted((e1, e2) -> {
                    int valueComparison = e2.getValue().compareTo(e1.getValue());
                    if (valueComparison != 0) {
                        return valueComparison; 
                    } else {
                        return e1.getKey().compareTo(e2.getKey()); 
                    }
                })
                .mapToInt(HashMap.Entry::getKey)
                .toArray();
    }
}