class Solution {
    public ArrayList<Integer> dfsGraph(int V , ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];

        dfs(0 , adj , visited , result);
        return result;
    }

    private void dfs(int node , ArrayList<Arraylist<Integer>> adj , boolean[] visited , ArrayList<Integer> result){
        visited[node] = true;
        result.add(node);

        for(int neighbor : adj.get(node)){
        if(!visited(node){
            dfs(neighbor , adj , visited , result);
        }
    }
}
}