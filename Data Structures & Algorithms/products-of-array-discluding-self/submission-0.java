class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] result = new int[n];

        // Calculate left products
        int leftProduct = 1;

        for (int i = 0; i < n; i++) {

            result[i] = leftProduct;

            leftProduct = leftProduct * nums[i];
        }

        // Calculate right products
        int rightProduct = 1;

        for (int i = n - 1; i >= 0; i--) {

            result[i] = result[i] * rightProduct;

            rightProduct = rightProduct * nums[i];
        }

        return result;
    }
} 
