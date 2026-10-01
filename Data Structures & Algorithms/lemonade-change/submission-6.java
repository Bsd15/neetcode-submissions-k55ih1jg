class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0, tens = 0;
        for (int b: bills) {
            if (b == 20) {
                if (tens >= 1 && fives >= 1) {
                    tens--;
                    fives--;
                } else if (fives >= 3) {
                    fives -= 3;
                } else {
                    return false;
                }
            } else if (b == 10) {
                tens++;
                if (fives >= 1) {
                    fives--;
                } else {
                    return false;
                }
            } else {
                fives++;
            }
        }
        return true;
    }
}