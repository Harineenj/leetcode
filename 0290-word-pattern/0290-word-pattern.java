class Solution {
    public boolean wordPattern(String pattern, String s) {
     HashMap<String,Character> h1= new HashMap<>();
     String str[] = s.split(" ");
     if(pattern.length()!=str.length)
     {
        return false;
     } 
     for(int i=0;i<str.length;i++)
     {
        if(h1.containsKey(str[i]))
        {
            if(h1.get(str[i])!=pattern.charAt(i))
            {
                return false;
            }
        }
        else
        {
            if(h1.containsValue(pattern.charAt(i)))
            {
                   return false; 
            }
            h1.put(str[i],pattern.charAt(i));
        }
     }
     return true;
    }
}