class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = n - 1; i >= 0; i--) {
            int[] freq = count.clone();
            boolean possible = true;

            for (int j = 0; j < i; j++) {
                int x = target.charAt(j) - 'a';
                freq[x]--;

                if (freq[x] < 0) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                continue;
            }

            int cur = target.charAt(i) - 'a';

            for (int j = cur + 1; j < 26; j++) {
                if (freq[j] > 0) {
                    StringBuilder ans = new StringBuilder();

                    ans.append(target, 0, i);
                    ans.append((char) ('a' + j));

                    freq[j]--;

                    for (int k = 0; k < 26; k++) {
                        while (freq[k] > 0) {
                            ans.append((char) ('a' + k));
                            freq[k]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}