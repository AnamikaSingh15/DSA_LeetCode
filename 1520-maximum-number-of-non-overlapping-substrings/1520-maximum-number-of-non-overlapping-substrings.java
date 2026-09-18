import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        // First and last occurrence of each character
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c] = i;
        }

        // Store valid intervals
        List<int[]> intervals = new ArrayList<>();

        for (int c = 0; c < 26; c++) {

            if (first[c] == n)
                continue;

            int l = first[c];
            int r = last[c];

            boolean valid = true;

            for (int i = l; i <= r; i++) {

                int current = s.charAt(i) - 'a';

                // Character appeared before l
                if (first[current] < l) {
                    valid = false;
                    break;
                }

                // Need to extend the interval
                r = Math.max(r, last[current]);
            }

            if (valid) {
                intervals.add(new int[]{l, r});
            }
        }

        // Sort by ending position
        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        List<String> result = new ArrayList<>();

        int end = -1;

        for (int[] interval : intervals) {

            if (interval[0] > end) {
                result.add(s.substring(interval[0], interval[1] + 1));
                end = interval[1];
            }
        }

        return result;
    }
}