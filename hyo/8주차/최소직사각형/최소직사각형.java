class Solution {
    public int solution(int[][] sizes) {
        int wMax = 0;
        int hMin = 0;

        for(int[] size : sizes) {
            wMax = Math.max(wMax, size[0] > size[1] ? size[0] : size[1]);
            hMin = Math.max(hMin, size[0] > size[1] ? size[1] : size[0]);
        }
        
        return wMax * hMin;
    }
}