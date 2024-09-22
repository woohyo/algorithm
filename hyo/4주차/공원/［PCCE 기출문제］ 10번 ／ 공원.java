import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        int maxSize = -1;

        for (int matSize : mats) {
            if (checkPlaceMat(matSize, park)) {
                maxSize = matSize;
            } else {
                break;
            }
        }
        return maxSize;
    }

    private static boolean checkPlaceMat(int matSize, String[][] park) {
        for (int i = 0; i <= park.length - matSize; i++) {
            for (int j = 0; j <= park[0].length - matSize; j++) {
                if (checkUnfoldMat(i, j, matSize, park)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkUnfoldMat(int x, int y, int matSize, String[][] park) {
        for (int i = x; i < x + matSize; i++) {
            for (int j = y; j < y + matSize; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
        
}