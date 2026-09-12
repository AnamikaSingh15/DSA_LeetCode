import java.util.*;

class Solution {

    static class Interval {
        int left, right, weight, index;

        Interval(int left, int right, int weight, int index) {
            this.left = left;
            this.right = right;
            this.weight = weight;
            this.index = index;
        }
    }

    static class Result {
        long weight;
        List<Integer> indices;

        Result(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    private Result[][] dp;
    private List<Interval> arr;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> x = intervals.get(i);

            arr.add(new Interval(
                x.get(0),
                x.get(1),
                x.get(2),
                i
            ));
        }

        // Sort by starting point
        arr.sort(Comparator.comparingInt(a -> a.left));

        dp = new Result[n][5];

        Result ans = solve(0, 4);

        int[] result = new int[ans.indices.size()];

        for (int i = 0; i < ans.indices.size(); i++) {
            result[i] = ans.indices.get(i);
        }

        return result;
    }

    private Result solve(int i, int remaining) {

        if (i == arr.size() || remaining == 0) {
            return new Result(0, new ArrayList<>());
        }

        if (dp[i][remaining] != null) {
            return dp[i][remaining];
        }

        // Option 1: Don't choose current interval
        Result skip = solve(i + 1, remaining);

        // Option 2: Choose current interval
        Interval current = arr.get(i);

        int next = findNext(i + 1, current.right);

        Result nextResult = solve(next, remaining - 1);

        List<Integer> selected = new ArrayList<>();

        selected.add(current.index);
        selected.addAll(nextResult.indices);

        Collections.sort(selected);

        Result take = new Result(
            current.weight + nextResult.weight,
            selected
        );

        if (take.weight > skip.weight) {
            dp[i][remaining] = take;
        }
        else if (take.weight < skip.weight) {
            dp[i][remaining] = skip;
        }
        else {
            
            if (compare(take.indices, skip.indices) < 0) {
                dp[i][remaining] = take;
            } else {
                dp[i][remaining] = skip;
            }
        }

        return dp[i][remaining];
    }

    
    private int findNext(int start, int right) {

        int low = start;
        int high = arr.size();

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr.get(mid).left > right) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int compare(List<Integer> a, List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }

        return Integer.compare(a.size(), b.size());
    }
}