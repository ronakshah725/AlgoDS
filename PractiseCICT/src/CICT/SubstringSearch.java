

public class SubstringSearch{

	//T:asasasdd
	//P:sasd
	static int isSubstringBrut(String text, String pattern){
		int plen = pattern.length(), tlen = text.length();
		for (int i = 0; i<=tlen-plen; i++)
		{		int j;
				for (j = 0;j< plen ;j++ ) 
					if(pattern.charAt(j) != text.charAt(i+j)) 
						break;
				if(j==plen) return i; 
		}
		return -1;
	}

	public static void main(String[] args) {
		String text = "asasasddsasdddt", pattern = "a";
		
		int found = SubstringSearch.isSubstringBrut(text, pattern);
		System.out.println("Pattern: " + pattern );
		System.out.println( text);
		StringBuffer pointerH=new StringBuffer("");

		for(int i = 0;i<found; i++){
			pointerH.append(" ");
		}
		pointerH.append("^");
		System.out.println(pointerH);
	}

}
