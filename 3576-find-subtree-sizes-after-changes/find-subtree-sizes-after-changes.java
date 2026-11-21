import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        List<Integer>[] original = new ArrayList[n];
        List<Integer>[] modified = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            original[i] = new ArrayList<>();
            modified[i] = new ArrayList<>();
        }

        // Build original tree
        for (int i = 1; i < n; i++) {
            original[parent[i]].add(i);
        }

        int[] last = new int[26];
        Arrays.fill(last, -1);

        int[] previous = new int[n];

        // DFS 1: Construct modified tree
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {

            int x = stack.pop();

            if (x >= 0) {

                int c = s.charAt(x) - 'a';

                previous[x] = last[c];

                int newParent = (last[c] != -1)
                                ? last[c]
                                : parent[x];

                if (newParent != -1) {
                    modified[newParent].add(x);
                }

                last[c] = x;

                // Exit marker
                stack.push(-x - 1);

                for (int child : original[x]) {
                    stack.push(child);
                }

            } else {

                int xNode = -x - 1;

                int c = s.charAt(xNode) - 'a';

                last[c] = previous[xNode];
            }
        }

        // DFS 2: Calculate subtree sizes
        int[] ans = new int[n];

        List<Integer> order = new ArrayList<>();

        stack.push(0);

        while (!stack.isEmpty()) {

            int node = stack.pop();

            order.add(node);

            for (int child : modified[node]) {
                stack.push(child);
            }
        }

        // Reverse order = children before parents
        for (int i = order.size() - 1; i >= 0; i--) {

            int node = order.get(i);

            ans[node]++;

            for (int child : modified[node]) {
                ans[node] += ans[child];
            }
        }

        return ans;
    }
}