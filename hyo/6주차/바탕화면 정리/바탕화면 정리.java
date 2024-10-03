class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = wallpaper.length;  //시작점(세로)
        int luy = wallpaper[0].length();  //시작점(가로)
        int rdx = 0; //끝점(세로)
        int rdy = 0; //끝점(가로)

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i);
                    rdy = Math.max(rdy, j);
                }
            }
        }
        return new int[]{lux, luy, rdx + 1, rdy + 1};
    }
}