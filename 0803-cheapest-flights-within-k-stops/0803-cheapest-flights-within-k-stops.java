class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        int temp[]=Arrays.copyOf(dist,n);
        for(int i=0;i<=k;i++)
        {
            for(int j=0;j<flights.length;j++)
            {
             int s=flights[j][0];
             int d=flights[j][1];
             int w=flights[j][2];
             if(dist[s]!=Integer.MAX_VALUE && dist[s]+w<temp[d])
             {
                temp[d]=dist[s]+w;
             }
            }
            dist=Arrays.copyOf(temp,n);
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst]; 
    }
}