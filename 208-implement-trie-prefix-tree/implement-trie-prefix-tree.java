class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}
class Trie {
        TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';

            if(curr.children[index] == null){
                return false;
            }
            curr = curr.children[index];
        }    

        return curr.isEnd;
        
        }
    
    public boolean startsWith(String prefix) {
         TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(curr.children[index] == null){
                return false;
            }
            curr = curr.children[index];
        }    

        return true;
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */