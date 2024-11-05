class Solution {
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,int visit[])
    {
        visit[node]=1;
        for(int a:adj.get(node))
        {
            if(visit[a]==0)
            {
                dfs(a,adj,visit);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int m=isConnected.length;
        int n=isConnected[0].length;
         ArrayList<ArrayList<Integer>> ad=new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            ad.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isConnected[i][j]==1 && i!=j)
                {
                    ad.get(i).add(j);
                    ad.get(j).add(i);
                }
            }
        }
        int visit[]=new int[n]; 
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(visit[i]==0)
            {
                count++;
                dfs(i,ad,visit);
            }
        }
       return count;
    }
}