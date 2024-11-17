class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++) {
            answer = countDivisors(i) % 2 == 0 ? answer + i : answer - i;
        }
        
        return answer;
    }
    
    public int countDivisors(int n) {
        int count = 0;
        
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {  
                count++;
                if (i != n / i) {
                    count++; 
                }
            }
        }
        return count;
    }
}