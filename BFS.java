public static void bfs(ArrayList<Edge> graph[],int v){ // two more parameter(boolean visited[],int start)
  Queue<Integer> q=new LinkedList<>();
  boolean visited[]=new boolean[v]; // will be defined in main block
  q.add(0);   //instead of 0 we will put start here
  while(!q.isEmpty()){
    int curr=q.remove();
    if(!visited[curr]){
      System.out.print(curr+" ");
      visited[curr]=true;
      for(int i=0;i<graph[curr].size();i++){
        Edge e=graph[curr].get(i);
        if(!visited[e.des])
          q.add(e.des);
      }
    }
  }

}

//in case of disjoin graph islands
/*
public static void main(String args[]){
  boolean visted will be shifted here from bfs
  instead of taking start point as 0 we will take start from here
    boolean visited[]=new boolean[v];
    for(int i=0;i<v;i++){
      if(!visited[i])
        bfs(graph,v,visited,i)   here i is starting point
    }
}
*/
