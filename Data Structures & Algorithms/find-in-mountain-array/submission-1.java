/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // find the peak
        final int length = mountainArr.length();
        int l = 1;
        int r = length - 2;
        int peak = 0;
         while (l <= r) {
            int m = l + ((r - l) / 2);
            int lVal = mountainArr.get(m - 1);
            int mVal = mountainArr.get(m);
            int rVal = mountainArr.get(m + 1);
            if (lVal < mVal && mVal > rVal) {
                peak = m;
                break;
            } else if (lVal > mVal) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        l = 0;
        r = peak;
        while (l <= r) {
            int m = l + ((r - l)/2);
            final int mVal = mountainArr.get(m);
            if (mVal == target) {
                return m;
            } else if (mVal > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        l = length - 1;
        r = peak;
        while (r <= l) {
            int m = r + ((l - r)/2);
            int mVal = mountainArr.get(m);
            if (mVal == target) {
                return m;
            } else if (mVal > target) {
                r = m + 1;
            } else {
                l = m - 1;
            }
        }
        return -1;
    }
}