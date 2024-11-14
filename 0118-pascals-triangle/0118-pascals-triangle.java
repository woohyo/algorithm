class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (numRows == 0){
            return result;
        } 
        
        List<Integer> currRow = new ArrayList<>();
        currRow.add(1);
        result.add(currRow);
        
        for(int i = 1; i < numRows; i++) {
           List<Integer> prevRow = result.get(i-1);
           currRow = new ArrayList<>();
           
            // 첫 행
           currRow.add(1);
           
           for (int j = 1; j < i; j++) {
               currRow.add(prevRow.get(j-1) + prevRow.get(j));
           }    
               
           // 마지막 행 
           currRow.add(1); 
           result.add(currRow); 
        }
        return result;
   }
}
