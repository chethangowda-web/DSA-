class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int l = 0;
        int r = n - 1;

        int lmax = 0;
        int rmax = 0;

        int water = 0;

        while (l <= r) {

            if (height[l] <= height[r]) {

                if (height[l] >= lmax) {
                    lmax = height[l];
                } else {
                    water += lmax - height[l];
                }

                l++;

            } else {

                if (height[r] >= rmax) {
                    rmax = height[r];
                } else {
                    water += rmax - height[r];
                }

                r--;
            }
        }

        return water;
    }
}