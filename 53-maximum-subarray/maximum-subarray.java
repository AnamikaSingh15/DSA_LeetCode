class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum=0;
        int MaxSum = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            sum = sum + nums[i];
            if (sum>MaxSum){
                MaxSum = sum;
            }
            if(sum<0){
                sum = 0;
            }
          

        }
          return MaxSum;
    }
}