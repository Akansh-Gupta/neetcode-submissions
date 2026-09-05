class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        Integer[] cars = new Integer[n];

        for (int i = 0; i < n; i++) {
            cars[i] = i;
        }

        // Sort by position in descending order
        Arrays.sort(cars, (a, b) -> position[b] - position[a]);

        int fleets = 0;
        double lastTime = 0;

        for (int i : cars) {
            double time = (double) (target - position[i]) / speed[i];

            if (time > lastTime) {
                fleets++;
                lastTime = time;
            }
        }

        return fleets;
    }
}