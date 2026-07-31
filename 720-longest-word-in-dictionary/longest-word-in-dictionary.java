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

    public boolean check(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            node = node.children[i];
            if(node == null || !node.isEnd){
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }

        String ans = "";
        for(String word : words){
            if(trie.check(word)){
                if(word.length() > ans.length()){
                    ans = word;
                }else if(word.length() == ans.length() && word.compareTo(ans) < 0){
                    ans = word;
                }
            }
        }
        return ans;
    }
}