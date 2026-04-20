package lc2069;

public class Robot {
    int width = 0;
    int height = 0;
    int x = 0;
    int y = 0;
    int direction = 1;//1为东，2为北，3为西，4为南

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void step(int num) {
       ;
        if ( (num%=(width-1+height-1)*2)==0&&x==0&&y==0){
            direction=4;
        }
        num%=(width-1+height-1)*2;
        for (int i = 0; i < num; i++) {
            if (direction == 1) {
                if (x < width - 1) {
                    x += 1;
                } else {
                    direction += 1;
                    y += 1;
                }
            } else if (direction == 2) {
                if (y < height - 1) {
                    y += 1;
                } else {
                    direction += 1;
                    x -= 1;
                }
            } else if (direction == 3) {
                if (x > 0) {
                    x -= 1;
                } else {
                    direction += 1;
                    y -= 1;
                }
            } else {
                if (y > 0) {
                    y -= 1;
                } else {
                    direction = 1;
                    x += 1;
                }
            }
        }

    }

    public int[] getPos() {
        int[] res = {x, y};
        return res;
    }

    public String getDir() {
        String res;
        if (direction == 1) {
            res = "East";
        } else if (direction == 2) {
            res = "North";
        } else if (direction == 3) {
            res = "West";
        } else {
            res = "South";
        }
        return res;
    }
}
