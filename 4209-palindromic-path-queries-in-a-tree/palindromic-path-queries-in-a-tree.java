import java.util.*;

class Solution {

    int[][] up;
    int[] depth;
    int LOG;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {

        List<Boolean> result = new ArrayList<>();

        // Build the tree
        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        // Prepare parent, depth, and Euler tour
        int[] parent = new int[n];
        int[] tin = new int[n];
        int[] tout = new int[n];
        int[] iter = new int[n];

        Arrays.fill(parent, -1);

        depth = new int[n];

        int timer = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        parent[0] = 0;
        tin[0] = timer++;

        // Iterative DFS
        while (!stack.isEmpty()) {

            int u = stack.peek();

            if (iter[u] < adj[u].size()) {

                int v = adj[u].get(iter[u]++);

                if (v == parent[u]) {
                    continue;
                }

                parent[v] = u;
                depth[v] = depth[u] + 1;
                tin[v] = timer++;

                stack.push(v);

            } else {

                tout[u] = timer - 1;
                stack.pop();
            }
        }

        // Binary lifting table for LCA
        LOG = 1;

        while ((1L << LOG) <= n) {
            LOG++;
        }

        up = new int[LOG][n];

        for (int i = 0; i < n; i++) {
            up[0][i] = parent[i];
        }

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        // Current character mask of each node
        int[] charMask = new int[n];

        for (int i = 0; i < n; i++) {
            charMask[i] = 1 << (s.charAt(i) - 'a');
        }

        // Initial root-to-node prefix XOR masks
        int[] base = new int[n];

        for (int i = 0; i < n; i++) {
            int u = i;

            if (u == 0) {
                base[tin[u]] = charMask[u];
            } else {
                base[tin[u]] = base[tin[parent[u]]] ^ charMask[u];
            }
        }

        // Fenwick tree for range XOR updates and point queries
        Fenwick bit = new Fenwick(n);

        // Process queries
        for (String query : queries) {

            String[] parts = query.split("\\s+");

            if (parts[0].equals("update")) {

                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                int newMask = 1 << (c - 'a');

                // Difference between old and new character
                int delta = charMask[u] ^ newMask;

                if (delta != 0) {
                    // Update root-prefix masks for the entire subtree
                    bit.rangeXor(tin[u], tout[u], delta);

                    charMask[u] = newMask;
                }

            } else if (parts[0].equals("query")) {

                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                // Current root-to-node masks
                int maskU = base[tin[u]] ^ bit.pointQuery(tin[u]);
                int maskV = base[tin[v]] ^ bit.pointQuery(tin[v]);

                // Lowest common ancestor
                int ancestor = lca(u, v);

                // XOR mask of the complete path
                int pathMask = maskU ^ maskV ^ charMask[ancestor];

                // A palindrome is possible if at most one bit is set
                result.add((pathMask & (pathMask - 1)) == 0);
            }
        }

        return result;
    }

    // Lowest Common Ancestor using binary lifting
    private int lca(int u, int v) {

        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int k = 0; k < LOG; k++) {
            if ((diff & (1 << k)) != 0) {
                u = up[k][u];
            }
        }

        if (u == v) {
            return u;
        }

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return up[0][u];
    }

    // Fenwick Tree supporting range XOR updates and point queries
    static class Fenwick {

        int n;
        int[] tree;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        private void add(int index, int value) {

            while (index <= n) {
                tree[index] ^= value;
                index += index & -index;
            }
        }

        private int prefixXor(int index) {

            int result = 0;

            while (index > 0) {
                result ^= tree[index];
                index -= index & -index;
            }

            return result;
        }

        void rangeXor(int left, int right, int value) {

            add(left + 1, value);
            add(right + 2, value);
        }

        int pointQuery(int index) {
            return prefixXor(index + 1);
        }
    }
}