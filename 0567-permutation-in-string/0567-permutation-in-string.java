class Solution {

    static boolean compareFreq(int[] count1, int[] count2) {
        for(int i = 0; i < 26; i++) {
            if(count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];

        // Frequency table for s1
        for(int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            int index = ch - 'a';
            count1[index]++;
        }

        int windowLength = s1.length();
        int[] count2 = new int[26];

        // First window
        for(int i = 0; i < windowLength; i++) {
            char ch = s2.charAt(i);
            int index = ch - 'a';
            count2[index]++;
        }

        if(compareFreq(count1, count2)) {
            return true;
        }

        // Sliding window
        int i = windowLength;

        while(i < s2.length()) {

            // Add new character
            char newChar = s2.charAt(i);
            int newIndex = newChar - 'a';
            count2[newIndex]++;

            // Remove old character
            char oldChar = s2.charAt(i - windowLength);
            int oldIndex = oldChar - 'a';
            count2[oldIndex]--;

            // Compare frequency tables
            if(compareFreq(count1, count2)) {
                return true;
            }

            i++;
        }

        return false;
    }
}