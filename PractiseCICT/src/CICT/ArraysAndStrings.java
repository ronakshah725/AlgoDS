

public class ArraysAndStrings{
	
	public static boolean oneEditAway(String s1, String s2){
		if(s1==null || s2 == null)
			return false;
		int l1 = s1.length(), l2 = s2.length();	
		if ((l2-l1)>1) 
			return false;

		int edits = 0;
		if(l1!=l2){
			//s1 : "b", s2 : "cb"
			//s1 : "cb", s2 : "b"
			//s1 : "bb", s2 : "b"
			//s1 : "cb", s2 : "d"
			//s1 : "cbd", s2 : "bd"
			//
			String big = l1<l2 ? s2 : s1;
			String small = l1<l2 ? s1 : s2;

			for (int i=0;i<small.length() ; i++ ) {
				if(edits < 2){
					if(small.charAt(i)!=big.charAt(i)){
						if(small.charAt(i) == big.charAt(i+1))
							edits++;
						else 
							return false;
					}
				}else 
					break;
			}
			
		}else{
			for (int i=0;i<s1.length() ; i++ ) {
				if(edits < 2)
					if(s1.charAt(i) != s2.charAt(i))
							edits++; //replace
				else 
					break;
			}
			
		}

		return edits < 2; //if there is a edit left, return true, since the
							  // the strings differ by just one one length

	}

	public static void main(String[] args) {
		// ArraysAndStrings as;
		System.out.println("pale" + ", " + "bale: " + ArraysAndStrings.oneEditAway("pale", "bale"));
		System.out.println("ple" + ", " + "bale: " + ArraysAndStrings.oneEditAway("ple", "bale"));
		System.out.println("p" + ", " + "\"\": " + ArraysAndStrings.oneEditAway("p", ""));
		System.out.println("b" + ", " + "cb: " + ArraysAndStrings.oneEditAway("b", "cb"));
		System.out.println("ronak" + ", " + "ronk: " + ArraysAndStrings.oneEditAway("ronak", "ronk"));
		// System.out.println("b" + ", " + "cb: " + ArraysAndStrings.oneEditAway("b", "cb"));
		// System.out.println("b" + ", " + "cb: " + ArraysAndStrings.oneEditAway("b", "cb"));



	}

}
