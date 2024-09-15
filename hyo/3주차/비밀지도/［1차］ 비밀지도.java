class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] resultMap = new String[n];

        for(int i = 0; i < n; i++) {
            String partMap = "";
            String binaryStringArr1 = String.format("%" + n + "s", Integer.toBinaryString(arr1[i])).replace(' ', '0');
            String binaryStringArr2 = String.format("%" + n + "s", Integer.toBinaryString(arr2[i])).replace(' ', '0');
            for(int j = 0; j < binaryStringArr1.length(); j++) {
                if(binaryStringArr1.charAt(j) == '1' || binaryStringArr2.charAt(j) == '1') {
                    partMap += "#";
                } else {
                    partMap += " ";
                }
            }
            resultMap[i] = partMap;
        }
        return resultMap;
    }
}