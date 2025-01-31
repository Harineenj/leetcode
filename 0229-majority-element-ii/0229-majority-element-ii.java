class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int max=nums.length/3;
        List<Integer> list1=new ArrayList<>();
        Map<Integer,Integer> m1=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            m1.put(nums[i],m1.getOrDefault(nums[i],0)+1);
        }
        for(int x:m1.keySet())
        {
            if(m1.get(x)>max)
            {
                list1.add(x);
            }
        }
        return list1;
    }
}