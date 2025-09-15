class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i< brokenLetters.length(); i++) {
            set.add(brokenLetters.charAt(i));
        }
        boolean canType = true;
        int count = 0;
        for(int i = 0; i< text.length(); i++) {
            char c = text.charAt(i);
            if(set.contains(c)){
                canType = false;
            }
            if(c == ' ') {
                if(canType){
                    count++;
                }
                else {
                    canType = true;
                }
            }
        }
        if(canType){
            count++;
        }
        return count;
    }
}