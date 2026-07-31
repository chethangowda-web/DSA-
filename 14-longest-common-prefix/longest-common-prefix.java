class TrieNode{
    TrieNode[] children;
    boolean isEnd;

    public TrieNode(){
        children = new TrieNode[26];
        isEnd = false;
    }
}
class Trie{
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            if(node.children[i] == null){
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }

        node.isEnd = true;
    }
    public String longestPrefix(){
        StringBuilder ans = new StringBuilder();
        TrieNode node = root;

        while(true){
            int count = 0;
            int next = -1;

        for(int i = 0; i < 26; i++){
            if(node.children[i] != null){
                count++;
                next = i;
            }
        } 
        // stop if branching occurs or a word ends
        if(count != 1 || node.isEnd){
            break;
        }
        ans.append((char) (next + 'a'));
        node = node.children[next];
        }
        return ans.toString();
    }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // base cases 
        if(strs == null || strs.length == 0)
            return "";
        Trie trie = new Trie();
        for(String word : strs){
            trie.insert(word);
        }
        return trie.longestPrefix();
        }
    }
