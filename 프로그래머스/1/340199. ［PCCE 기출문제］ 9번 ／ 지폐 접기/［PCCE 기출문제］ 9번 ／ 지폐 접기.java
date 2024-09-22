class Solution {
    public int solution(int[] wallet, int[] bill) {
        int foldCnt = 0;
        boolean isPut = false;
        while (!isPut) {
            if(wallet[0] >= bill[0] && wallet[1] >= bill[1]) {
                isPut = true;
            } else if(wallet[0] >= bill[1] && wallet[1] >= bill[0]) {
                isPut = true;
            } else {
                ++foldCnt;
                if(bill[0] > bill[1]) {
                    bill[0] = (int)(bill[0] / 2);
                } else if(bill[0] < bill[1]) {
                    bill[1] = (int)(bill[1] / 2);
                }
            }
        }
        return foldCnt;
    }
}