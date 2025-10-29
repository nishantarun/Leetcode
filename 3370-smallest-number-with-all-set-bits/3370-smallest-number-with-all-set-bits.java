class Solution {
    public int smallestNumber(int n) {
        for(int i = 0; i <11; i++) {
            int setBitNum = (int)Math.pow(2, i) - 1;
            if(setBitNum >= n) return setBitNum;
        }
        return 0;
    }
}