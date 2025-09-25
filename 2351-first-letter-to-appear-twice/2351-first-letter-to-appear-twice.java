class Solution {
    public char repeatedCharacter(String s) {
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            if(!set.add(c)){
                return c;
            }
        }
        return 'c';
    }
}