class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> h1=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            h1.put(arr[i],h1.getOrDefault(arr[i],0)+1);
        }
        int max=0;
        for(int i:h1.keySet())
        {
           if(i==h1.get(i))
           {
            if(i>max)
            {
                max=i;
            }
           }
        }
        if(max==0)
        {
            return -1;
        }
        else
           return max;
    }
}