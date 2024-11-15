class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> allRows = new ArrayList<>();
        List<Integer> targetRow = new ArrayList<>();
        targetRow.add(1);
        allRows.add(targetRow);
        if(rowIndex == 0) return targetRow;
        
        for(int i =  1; i < rowIndex + 1; i++) {
            targetRow = new ArrayList<>();
            
            // 첫 행
            targetRow.add(1);
            
            for(int j = 1; j < i; j++) {
                targetRow.add(allRows.get(i - 1).get(j - 1) + allRows.get(i - 1).get(j));
            }
            
            // 마지막 행
            targetRow.add(1);
            allRows.add(targetRow);
        }
        return targetRow;  
    }
}