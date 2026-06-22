package lc1300_lc1399.lc1344;

class Solution {
    public double angleClock(int hour, int minutes) {
        double time =(hour+((double)minutes/60))*5%60;
        double a = Math.abs(time-minutes);
        double res = a*6;
        if(a*6>180){
            return (double)360-a*6;
        }
        return a*6;
    }
}