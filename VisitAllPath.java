//print all paths in graph from source to target
public static void visitpath(ArrayList<Edge> graph[],boolean  visited[],int src,int target,String path){
  if(src==target){
    System.out.print(path);
    return;
  }
  for(int i=0;i<graph[src].size();i++){
    Edge e=graph[src].get(i);
    if(!visited[e.des]){
      visited[src]=true;
      visitpath(graph,visited,e.des,target,path+e.des);
      visited[src]=false;
    }
  }
}

/* DFS method*/
