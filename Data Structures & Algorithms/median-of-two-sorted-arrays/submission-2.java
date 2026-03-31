class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int A = nums1.length;
        int B = nums2.length;

        int total = A + B;
        int l = 0; 
        int r = A;
        while (l <= r) {
            int midA = (l + r) / 2;
            int midB = ((total + 1)/2) - midA;
            System.out.println(midA);
            System.out.println(midB);
            
            int leftMaxA = midA == 0 ? Integer.MIN_VALUE : nums1[midA - 1];
            int rightMinA = midA == A ? Integer.MAX_VALUE : nums1[midA];

            int leftMaxB = midB == 0 ? Integer.MIN_VALUE : nums2[midB - 1];
            int rightMinB = midB == B ? Integer.MAX_VALUE : nums2[midB];

            if (leftMaxA <= rightMinB && leftMaxB <= rightMinA) {
                if (total % 2 == 0) {
                    // even
                    return (double) (Math.max(leftMaxA, leftMaxB) + Math.min(rightMinA, rightMinB)) / 2;
                } else {
                    // odd
                    return Math.max(leftMaxA, leftMaxB);
                }

            } else if (leftMaxA > rightMinB) {
                r = midA - 1;
            } else {
                // leftMaxB > rightMinA
                l = midA + 1;
            }
        }
        return -1;
    }
}
