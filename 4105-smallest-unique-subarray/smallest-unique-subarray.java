import java.util.*;

class Solution {

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        int[] sa = buildSuffixArray(nums);
        int[] rank = new int[n];
        int[] lcp = new int[n];

        // Store the rank of every suffix
        for (int i = 0; i < n; i++) {
            rank[sa[i]] = i;
        }

        // Build LCP array using Kasai's algorithm
        int k = 0;

        for (int i = 0; i < n; i++) {
            int r = rank[i];

            if (r == 0) {
                continue;
            }

            int j = sa[r - 1];

            while (i + k < n && j + k < n &&
                   nums[i + k] == nums[j + k]) {
                k++;
            }

            lcp[r] = k;

            if (k > 0) {
                k--;
            }
        }

        int ans = n;

        // Find the shortest unique prefix
        for (int i = 0; i < n; i++) {

            int maxLcp = lcp[i];

            if (i + 1 < n) {
                maxLcp = Math.max(maxLcp, lcp[i + 1]);
            }

            int requiredLength = maxLcp + 1;

            if (requiredLength <= n - sa[i]) {
                ans = Math.min(ans, requiredLength);
            }
        }

        return ans;
    }

    private int[] buildSuffixArray(int[] nums) {

        int n = nums.length;
        int m = n + 1;

        int[] s = new int[m];

        for (int i = 0; i < n; i++) {
            s[i] = nums[i];
        }

        s[n] = 0; // Unique sentinel

        int alphabet = Math.max(100001, m);

        int[] p = new int[m];
        int[] c = new int[m];
        int[] cnt = new int[alphabet];

        // Initial sorting
        for (int x : s) {
            cnt[x]++;
        }

        for (int i = 1; i < alphabet; i++) {
            cnt[i] += cnt[i - 1];
        }

        for (int i = m - 1; i >= 0; i--) {
            p[--cnt[s[i]]] = i;
        }

        int classes = 1;
        c[p[0]] = 0;

        for (int i = 1; i < m; i++) {
            if (s[p[i]] != s[p[i - 1]]) {
                classes++;
            }

            c[p[i]] = classes - 1;
        }

        int[] pn = new int[m];
        int[] cn = new int[m];

        // Prefix doubling
        for (int len = 1; len < m; len <<= 1) {

            for (int i = 0; i < m; i++) {
                pn[i] = p[i] - len;

                if (pn[i] < 0) {
                    pn[i] += m;
                }
            }

            Arrays.fill(cnt, 0, classes, 0);

            for (int x : pn) {
                cnt[c[x]]++;
            }

            for (int i = 1; i < classes; i++) {
                cnt[i] += cnt[i - 1];
            }

            for (int i = m - 1; i >= 0; i--) {
                int x = pn[i];
                p[--cnt[c[x]]] = x;
            }

            cn[p[0]] = 0;
            int newClasses = 1;

            for (int i = 1; i < m; i++) {

                int cur = p[i];
                int prev = p[i - 1];

                int mid1 = (cur + len) % m;
                int mid2 = (prev + len) % m;

                if (c[cur] != c[prev] ||
                    c[mid1] != c[mid2]) {
                    newClasses++;
                }

                cn[cur] = newClasses - 1;
            }

            int[] temp = c;
            c = cn;
            cn = temp;

            classes = newClasses;

            if (classes == m) {
                break;
            }
        }

        // Remove sentinel suffix
        int[] sa = new int[n];

        for (int i = 1; i < m; i++) {
            sa[i - 1] = p[i];
        }

        return sa;
    }
}