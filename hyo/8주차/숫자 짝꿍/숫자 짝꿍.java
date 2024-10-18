class Solution {
    public String solution(String x, String y) {
        int[] xCount = new int[10];
        int[] yCount = new int[10];

        for (char c : x.toCharArray()) {
            xCount[c - '0']++;
        }

        for (char c : y.toCharArray()) {
            yCount[c - '0']++;
        }

        StringBuilder commonNumbers = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int commonCount = Math.min(xCount[i], yCount[i]);
            for (int j = 0; j < commonCount; j++) {
                commonNumbers.append(i);
            }
        }

        if (commonNumbers.length() == 0) {
            return "-1";
        }
        if (commonNumbers.toString().matches("0+")) {
            return "0";
        }
        
        return commonNumbers.toString();
    }
}