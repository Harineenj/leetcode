class Pair
{
    int col;
    int row;
    Pair(int row,int col)
    {
        this.col=col;
        this.row=row;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
      int m=grid.length;
      int n=grid[0].length;
      int visit[][] = new int[m][n];
      Queue<Pair> queue=new LinkedList<>();
      for(int i=0;i<grid.length;i++)
      {
        for(int j=0;j<grid[0].length;j++)
        {
            if( (i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1)&&grid[i][j]==1)
            {
                queue.offer(new Pair(i,j));
                visit[i][j]=1;
            }     
        }
      } 
      while(!queue.isEmpty())
      {
            /*int up=queue.peek().col-1;
            int down=queue.peek().col+1;
            int right=queue.peek().row+1;
            int left=queue.peek().row-1;*/
            int ncol=queue.peek().col;
            int nrow=queue.peek().row;
            queue.poll();
          if(ncol-1>=0 && grid[nrow][ncol-1]==1 && visit[nrow][ncol-1]!=1)
          {
            queue.offer(new Pair(nrow,ncol-1));
            visit[nrow][ncol-1]=1;
          }
          if(ncol+1<n && grid[nrow][ncol+1]==1 && visit[nrow][ncol+1]!=1)
          {
            queue.offer(new Pair(nrow,ncol+1));
            visit[nrow][ncol+1]=1;
          }
          if(nrow-1>=0 && grid[nrow-1][ncol]==1 && visit[nrow-1][ncol]!=1)
          {
            queue.offer(new Pair(nrow-1,ncol));
            visit[nrow-1][ncol]=1;
          }
          if (nrow + 1 < m && grid[nrow + 1][ncol] == 1 && visit[nrow + 1][ncol] != 1)

          {
            queue.offer(new Pair(nrow+1,ncol));
            visit[nrow+1][ncol]=1;
          }
      }
      int ans=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1 && visit[i][j]==0)
                {
                     ans++;
                }
            }
        }
        return ans;
    }
}