public static void dfs(ArrayList<Edge> graph[],int curr,boolean visited){
    System.out.print(curr+" ");
    visited[curr]=true;
    for(int i=0;i<graph[curr].size();i++){
      Edge e=graph[curr].get(i);
      if(!visited[e.des])
      dfs(graph,e.des,visited);
    }
}

/*
in case of islands (disjoint graphs)
in main function 
boolean visited[]=new boolean[V];
for(int i=0;i<V;i++){
  if(visited[i]==false){
    dfs(graph,i,visited);
  }
}
*/
