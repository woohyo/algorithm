import java.util.*;

class Solution {

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        List<String> col = List.of("code", "date", "maximum", "remain");
        int searchIdx = col.indexOf(ext);
        int sortIdx = col.indexOf(sort_by);
        
        for(int i = 0; i < data.length; i++){
            if(data[i][searchIdx] < val_ext) {
                answer = addEl(answer, data[i]);
            }
        }
        // 정렬
        Arrays.sort(answer, (a, b) -> Integer.compare(a[sortIdx], b[sortIdx]));
        
        return answer;
    }
    
    public int[][] addEl(int[][] originArr, int[] add) {
        int[][] newArr = Arrays.copyOf(originArr, originArr.length + 1);
        newArr[originArr.length] = add;
        return newArr;
    }
}