class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        final int OP_ST_SEC = timeToSeconds(op_start);
        final int OP_EN_SEC = timeToSeconds(op_end);
        int posSec = timeToSeconds(pos);

        // 오프닝 건너뛰기
        if(isOpSection(posSec, OP_ST_SEC, OP_EN_SEC)) posSec = OP_EN_SEC;

        int videolenSec = timeToSeconds(video_len);

        // 명령어 수행
        for(String command : commands) {
            switch (command) {
                case "prev":
                    if (posSec - 10 < 0) {
                        posSec = 0;
                    } else {
                        posSec -= 10;
                    }
                    break;
                case "next":
                    if (posSec + 10 > videolenSec) {
                        posSec = videolenSec;
                    } else {
                        posSec += 10;
                    }
                    break;
            }

            posSec = isOpSection(posSec, OP_ST_SEC, OP_EN_SEC) ? OP_EN_SEC : posSec;
        }
        return secondsToTime(posSec);
    }

    private boolean isOpSection(int posSec, int opStSec, int opEnSec) {
      return posSec >= opStSec && posSec <= opEnSec ? true : false;
    }

    public int timeToSeconds(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }

    public String secondsToTime(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}