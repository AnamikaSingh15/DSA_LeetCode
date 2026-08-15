class Solution {
    public int longestSubsequence(int[] nums) {
        int num = 0;
        int n = nums.length;
        int arr[] = new int[n]; // initialize the array
        if(Arrays.equals(nums,arr)){
            return 0;
        }
        for(int i = 0; i<n; i++){
            num = num ^ nums[i] ;

        }
        
        return num!=0 ? n:n-1;

    }
}