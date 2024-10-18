class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] pronouncedList = {"aya", "ye", "woo", "ma"};

        for(int i = 0; i < babbling.length; i++) {
            for(int j = 0; j < pronouncedList.length; j++) {
                babbling[i] = babbling[i].replaceAll(pronouncedList[j], String.valueOf(j + 1));
            }
            
            if (isNumeric(babbling[i]) && !isContainsRepeat(babbling[i])) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isNumeric(String targetStr) {
        // 문자열이 숫자로만 구성되어 있는지 확인
        for (int i = 0; i < targetStr.length(); i++) {
            if (!Character.isDigit(targetStr.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isContainsRepeat(String targetStr) {
        // 동일한 숫자가 연속적으로 나오는지 확인
        for (int i = 1; i < targetStr.length(); i++) {
            if (targetStr.charAt(i) == targetStr.charAt(i - 1)) {
                return true;
            }
        }
        return false;
    }
}