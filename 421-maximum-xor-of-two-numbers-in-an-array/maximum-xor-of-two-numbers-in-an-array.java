class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    TrieNode root = new TrieNode();

    void insert(int num) {
        TrieNode node = root;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }

            node = node.children[bit];
        }
    }

    int findMaxXor(int num) {
        TrieNode node = root;
        int xor = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opposite = 1 - bit;

            if (node.children[opposite] != null) {
                xor |= (1 << i);
                node = node.children[opposite];
            } else {
                node = node.children[bit];
            }
        }

        return xor;
    }

    public int findMaximumXOR(int[] nums) {

        int maxXor = 0;

        for (int num : nums) {
            insert(num);
            maxXor = Math.max(maxXor, findMaxXor(num));
        }

        return maxXor;
    }
}