class Solution {
    public boolean isPalindrome(String s) {
        String letters = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] ch = letters.toCharArray();
        for(char c : ch){
            System.out.print(c+" ");
        }
        int l = 0;
        int r = ch.length-1;
        while(l<r){
            if(ch[l]!=ch[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
