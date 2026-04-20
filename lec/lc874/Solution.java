package com.sheeta1998.lec.lc874;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public void setAdd(Set<String> set, int a, int b) {
        String ad = a + "," + b;
        set.add(ad);
    }

    public boolean setCompare(Set<String> set, int a, int b) {
        String cp = a + "," + b;
        return !set.contains(cp);
    }


    public int robotSim(int[] commands, int[][] obstacles) {
        int res = 0;
        int sta = 1;// 1 北，2东，3南，4西
        int x = 0;
        int y = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            setAdd(set, obstacles[i][0], obstacles[i][1]);
        }
        for (int i = 0; i < commands.length; i++) {

            int a = commands[i];
            if (a < 0) {
                if (a == -1) {
                    if (sta != 4) {
                        sta += 1;
                    } else {
                        sta = 1;
                    }
                } else {
                    if (sta != 1) {
                        sta -= 1;
                    } else {
                        sta = 4;
                    }
                }
            } else {
                if (sta == 1) {
                    for (int j = 0; j < a; j++) {
                        if (!setCompare(set, x, y + 1)) {
                            break;
                        } else {
                            y++;
                        }

                    }
                    res= Math.max(res,x*x+y*y);
                } else if (sta == 2) {
                    for (int j = 0; j < a; j++) {
                        if (!setCompare(set, x + 1, y)) {
                            break;
                        } else {
                            x++;
                        }

                    }
                    res= Math.max(res,x*x+y*y);
                } else if (sta == 3) {
                    for (int j = 0; j < a; j++) {
                        if (!setCompare(set, x, y - 1)) {
                            break;
                        } else {
                            y--;
                        }

                    }
                    res= Math.max(res,x*x+y*y);
                } else {
                    for (int j = 0; j < a; j++) {
                        if (!setCompare(set, x - 1, y)) {
                            break;
                        } else {
                            x--;
                        }

                    }
                   res= Math.max(res,x*x+y*y);
                }
            }

        }

        return res;
    }
}