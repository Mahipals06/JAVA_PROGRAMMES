class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int []> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)
                q.offer(new int[] {i,j});
                else if(grid[i][j]==1)
                fresh++;
            }
        }
        int count=0;
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty() && fresh!=0){
            count++;
            int sz=q.size();
            for(int i=0;i<sz;i++){
                int[] rotten=q.poll();
                int r=rotten[0];
                int c=rotten[1];
                for(int[] dir:dirs){
                    int x=r+dir[0];
                    int y=c+dir[1];
                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
                        grid[x][y]=2;
                        q.offer(new int[] {x,y});
                        fresh--;
                    }
                }
            }
        }
        if(fresh==0)
        return count;
        return -1;

    }
}
