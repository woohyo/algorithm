import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int fn = friends.length;

        int [][] giveAndTakeArr = new int [fn][fn];
        int [] giftIndex = new int [fn];
        int [] giftResult = new int [fn];


        /* 이번달 선물 주고 받은 결과 데이터 계산 */
        int giveFrdIdx = 0;
        int takeFrdIdx = 0;

        for(int i = 0; gifts.length > i; i++) {
            giveFrdIdx = Arrays.asList(friends).indexOf(gifts[i].split(" ")[0]);
            takeFrdIdx = Arrays.asList(friends).indexOf(gifts[i].split(" ")[1]);

            giveAndTakeArr[giveFrdIdx][takeFrdIdx] += 1;
        }
        System.out.println(Arrays.deepToString(giveAndTakeArr));


        /* 선물 지수 계산 */
        for(int i = 0; fn > i; i++) {
            int totalGiveCnt = Arrays.stream(giveAndTakeArr[i]).sum();
            int totalTakeCnt = 0;
            for(int j = 0; fn > j; j++){
                totalTakeCnt += giveAndTakeArr[j][i];
            }
            giftIndex[i] = totalGiveCnt - totalTakeCnt;
        }
        System.out.println(Arrays.toString(giftIndex));


        /* 다음달 받을 선물 수 계산 */
        for(int i = 0; fn > i; i++){
            for(int j = 0; fn > j; j++){
                if(i != j) {
                    if(giveAndTakeArr[i][j] > giveAndTakeArr[j][i]) {
                        giftResult[i] += 1;
                    } else {
                        if((giveAndTakeArr[i][j] == giveAndTakeArr[j][i]) && (giftIndex[i] > giftIndex[j])) {
                            giftResult[i] += 1;
                        }
                    }
                }
            }
        }
        
        Arrays.sort(giftResult);
        System.out.println(Arrays.toString(giftResult));

        
        /* 가장 많은 선물을 받는 친구가 받을 선물의 수 */
        answer = giftResult[fn - 1];

        return answer;
    }
}