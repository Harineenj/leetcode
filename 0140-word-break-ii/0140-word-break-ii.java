
class Solution {
    public  void f(String s,Set<String> dic,List<String> lt,StringBuilder word,StringBuilder adder,int index,int size) {
		if(index==size) {
			if(s.isBlank()&&word.isEmpty()) { 
				lt.add(new String(adder));
			}
			return;
		}
		word=word.append(s.charAt(0)); 
		s=s.substring(1); 
		if(dic.contains(new String(word))) {
			StringBuilder oldAdder=new StringBuilder(adder);
			StringBuilder oldword=new StringBuilder(word);

			if(!adder.isEmpty()) adder.append(" ");
			adder.append(new String(word)); 
			word.delete(0, word.length());
			f(s,dic,lt,word,adder,index+1,size);
			adder=oldAdder;
			word=oldword;
		}

		f(s,dic,lt,word,adder,index+1,size);
		return;
	}
    public List<String> wordBreak(String s, List<String> wordDict) {
         Set<String> dic=new HashSet<>(wordDict);
	        List<String> lt=new LinkedList<>();
	        f(s,dic,lt,new StringBuilder(""),new StringBuilder(""),0,s.length());
	        return lt;
    }
}