class Solution {
    public int racecar(int target) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new int[]{0, 1, 0});
        visited.add("0,1");

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int pos = cur[0];
            int speed = cur[1];
            int steps = cur[2];

            if (pos == target) {
                return steps;
            }

            // Operation A: Accelerate
            int nextPos = pos + speed;
            int nextSpeed = speed * 2;

            // Bound the search space
            if (Math.abs(nextPos) <= 2 * target &&
                Math.abs(nextSpeed) <= 4 * target) {

                String key = nextPos + "," + nextSpeed;

                if (visited.add(key)) {
                    queue.offer(
                        new int[]{nextPos, nextSpeed, steps + 1}
                    );
                }
            }

            // Operation R: Reverse
            nextPos = pos;
            nextSpeed = speed > 0 ? -1 : 1;

            String key = nextPos + "," + nextSpeed;

            if (visited.add(key)) {
                queue.offer(
                    new int[]{nextPos, nextSpeed, steps + 1}
                );
            }
        }

        return -1;
    }
}
