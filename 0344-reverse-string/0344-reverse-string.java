class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int a = 0;
        int e = n-1;
        while(a<e){
            char temp = s[a];
            s[a]=s[e];
            s[e]=temp;
            a++;
            e--;

        



        }

    }
}