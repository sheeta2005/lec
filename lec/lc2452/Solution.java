package lc2452;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            for (String dic: dictionary){
                int count = 0;
                for (int j = 0; j < queries[i].length(); j++) {
                    if (queries[i].charAt(j) != dic.charAt(j)){
                        count++;
                    }
                    if (count > 2){
                        break;
                    }
                }
                if (count <= 2){ ans.add(queries[i]);break;}
            }
        }
        return  ans;
    }
}