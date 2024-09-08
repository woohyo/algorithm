class Solution {
    public int solution(String s) {
        int answer = 0;
        String [] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i < 10; i++){
            if(!s.contains(number[i])){
                continue;
            }
            s = s.replaceAll(number[i], Integer.toString(i));
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}