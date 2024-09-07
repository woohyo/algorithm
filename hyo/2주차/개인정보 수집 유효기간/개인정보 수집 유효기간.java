import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        ArrayList<Integer> answerArr = new ArrayList<>();

        int no = 1;

        for(String privacie: privacies) {
            String collectDate = privacie.split(" ")[0];
            String collectInfo = privacie.split(" ")[1];
            String term = Arrays.stream(terms).filter(t -> t.contains(collectInfo)).findFirst().get().split(" ")[1];
            DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

            LocalDate todayL = LocalDate.parse(today, fomatter);
            LocalDate date = LocalDate.parse(collectDate, fomatter);
            LocalDate expireDate = date.plus(Integer.parseInt(term), ChronoUnit.MONTHS);

            if(todayL.isAfter(expireDate) || todayL.isEqual(expireDate)){
                answerArr.add(no);
            }
            no++;

        }

        answer = new int[answerArr.size()];
        int size = 0;
        for (Integer temp : answerArr){
            answer[size++] = temp;
        }


        Arrays.sort(answer);

        return answer;
    }
}