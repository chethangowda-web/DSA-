import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];

        // Available servers: [weight, index]
        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            }
        );

        // Busy servers: [finishTime, weight, index]
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return Long.compare(a[0], b[0]);
                if (a[1] != b[1])
                    return Long.compare(a[1], b[1]);
                return Long.compare(a[2], b[2]);
            }
        );

        for (int i = 0; i < n; i++) {
            available.offer(new int[]{servers[i], i});
        }

        // IMPORTANT: Maintain global processing time
        long time = 0;

        for (int i = 0; i < m; i++) {

            // Time cannot move backwards
            time = Math.max(time, i);

            // Release completed servers
            while (!busy.isEmpty() && busy.peek()[0] <= time) {

                long[] curr = busy.poll();

                available.offer(new int[]{
                    (int) curr[1],
                    (int) curr[2]
                });
            }

            // If no server is available, wait
            if (available.isEmpty()) {

                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {

                    long[] curr = busy.poll();

                    available.offer(new int[]{
                        (int) curr[1],
                        (int) curr[2]
                    });
                }
            }

            // Select the best server
            int[] server = available.poll();

            int weight = server[0];
            int index = server[1];

            ans[i] = index;

            // Assign task
            busy.offer(new long[]{
                time + tasks[i],
                weight,
                index
            });
        }

        return ans;
    }
}