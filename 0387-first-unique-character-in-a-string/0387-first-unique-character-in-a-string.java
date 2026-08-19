class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer>list = new HashMap<>();
        int n = s.length();
        for(int i =0; i<n; i++){
            char ch = s.charAt(i);
            list.put(ch,list.getOrDefault(ch,0)+1);
        }

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(list.get(ch)==1){
                return i;
            }
        }
        return -1;
    }
}