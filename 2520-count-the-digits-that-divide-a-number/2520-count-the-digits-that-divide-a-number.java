class Solution {
    public int countDigits(int num) {
         int target = num;
        int count = 0;
        while(num!=0){
            int digit = num%10;
            num = num/10;
            if(target%digit==0){
           
                count ++;
            }

           }
           return count;
        
    }
}