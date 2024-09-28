import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        ArrayList<Integer> pointList = new ArrayList<>();
        for(int i = 0; i < photo.length; i++){
            int totalPoint = 0;
            for(int j = 0; j < photo[i].length; j++){
                String targetName = photo[i][j];
                int index = IntStream.range(0, name.length)
                        .filter(k -> name[k].equals(targetName))
                        .findFirst()
                        .orElse(-1);
                if(index != -1) {
                    totalPoint += yearning[index];
                }
            }
            pointList.add(totalPoint);
        }


        return pointList.stream().mapToInt(i -> i).toArray();
    }
}