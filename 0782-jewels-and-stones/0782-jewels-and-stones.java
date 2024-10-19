class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character,Integer> h1=new HashMap<>();
        for(int i=0;i<stones.length();i++)
        {
            h1.put(stones.charAt(i),h1.getOrDefault(stones.charAt(i),0)+1);
        }
        int sum=0;
        for(int i=0;i<jewels.length();i++)
        {
            char ch=jewels.charAt(i);
            if(h1.containsKey(ch))
            {
                sum=sum+h1.get(ch);
            }
        }
        return sum;
    }
}