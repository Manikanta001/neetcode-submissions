class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] sFreq = new int[26];
        // int[] tFreq = new int[26];

        for(char c : s.toCharArray()){
            sFreq[c-'a']++;
        }
       for(int i=0;i<t.length();i++){
            sFreq[t.charAt(i)-'a']--;
       }
       for(int n : sFreq){
        if(n>0) return false;
       }
       return true;
    }
}
