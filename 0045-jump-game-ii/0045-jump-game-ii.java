class Solution {
    public int jump(int[] nums) {
        int jumps=0,current=0,further=0;
        for(int i=0;i<nums.length-1;i++)
        {
            further=Math.max(further,i+nums[i]);
            if(i==current)
            {
                jumps++;
                current=further;
            }
        }
        return jumps;
    }
}