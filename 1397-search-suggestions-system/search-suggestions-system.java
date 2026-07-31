class TrieNode{
    TrieNode[] children;
    List<String> suggestions;

    public TrieNode(){
        children = new TrieNode[26];
        suggestions = new ArrayList<>();
    }
}
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        TrieNode root = new TrieNode();
        
        for(String product : products){
            TrieNode node = root;

            for(char c : product.toCharArray()){
                int i = c - 'a';

                if(node.children[i] == null){
                    node.children[i] = new TrieNode();
                }
                node = node.children[i];
            
            // store only 3 lexicographically smallest products

            if(node.suggestions.size() < 3){
                node.suggestions.add(product);
            }
        }
    }

    List<List<String>> ans = new ArrayList<>();
    TrieNode node = root;

    for(char c : searchWord.toCharArray()){
        if(node != null){
            node = node.children[c - 'a'];
        }
        if(node == null){
            ans.add(new ArrayList<>());
        }else{
            ans.add(new ArrayList<>(node.suggestions));
        }
    }
    return ans;
}
}