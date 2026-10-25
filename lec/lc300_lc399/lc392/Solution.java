package lc300_lc399.lc392;
class Solution {
    public boolean isSubsequence(String s, String t) {
           int pos1 = 0;
           int pos2 = 0;
            while (true){
                if (pos1==s.length()){return true;}
                if (pos2>=t.length()){return false;}
                if (s.charAt(pos1)==t.charAt(pos2)){
                    pos1++;
                    pos2++;
                }
                else {
                    pos2++;
                }
            }
    }
}