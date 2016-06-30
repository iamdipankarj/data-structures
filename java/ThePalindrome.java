public class ThePalindrome {
	
	public static int find(String s) {
		StringBuilder sb = new StringBuilder(s), sb1;
		String ret = new String();
		String temp = new String();
		
		// If this is already a palindrome
		if (sb.reverse().toString().equals(s)) return s.length();
		
		// Traverse through each character
		for (int i = 0; i < s.length(); i++) {
			temp += s.charAt(i); // Get the current character
			sb1 = new StringBuilder(temp); // Create string from current character
			ret = s+sb1.reverse().toString();
			sb = new StringBuilder(ret);
			if ( ret.equals(sb.reverse().toString()) ) {
				break;
			}
		}
		return ret.length();
	}

	public static void main(String[] args) {
		System.out.println(find("abacaba"));
	}

}
