class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        int max = 0;
        for (int f : freq) {
            max = Math.max(max, f);
        }

        int count = 0;
        for (int f : freq) {
            if (f == max) {
                count++;
            }
        }

        int result = (max - 1) * (n + 1) + count;

        return Math.max(result, tasks.length);
    }
}