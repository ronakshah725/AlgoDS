

/*Problem: Find if string is unique

Q1:Mix uppercase lower case
Q2:Limited to ASCII chars?
Q3:Unicode also?
Q4:Space constraints?
*/

public class UniqueString {
	
	public static boolean isUniqueASCII(String str){
		int[] charMap = new int[255];
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(charMap[(int)c] != 0 ){
				System.out.println("First Repeating char: " + c);
				return false;
			}
			charMap[(int)c]++;

		}
		System.out.println("Chars:");
		for (int i = 0; i < charMap.length; i++) {
			if(charMap[i]!=0)
				System.out.println((char)i);
		}
		return true;
		
	}
}
