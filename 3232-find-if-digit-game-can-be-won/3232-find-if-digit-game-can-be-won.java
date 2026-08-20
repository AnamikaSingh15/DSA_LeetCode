class Solution {
    public boolean canAliceWin(int[] nums) {
        int n = nums.length;
      int alice;
      int bob;
      int OneDigit = 0;
      int DoubleDigit = 0;
      for(int i = 0; i < n; i++){
        if(nums[i]>9){
            DoubleDigit = DoubleDigit + nums[i];
        }
        else{
            OneDigit = OneDigit + nums[i];
        }
    }
    return OneDigit!= DoubleDigit;
    }
}