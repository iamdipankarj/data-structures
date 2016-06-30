import java.util.*;

public class CodeBot {
	
	static boolean isUniqueChars(String str) {
		if (str == null) return false;
		if (str.length() > 256) return false;
		
		boolean[] charset = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (charset[val]) {
				return false;
			}
			charset[val] = true;
		}
		return true;
	}
	
	static boolean isUniqueChars2(String str) {
		if (str == null) return false;
		int checker = 0;
		
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			
			if ((checker & (1 << val)) > 0) return false;
			checker |= 1 << val;
		}
		
		return true;
	}
	
	static boolean isUniqueChars3(String str) {
		if (str == null) return false;
		char [] array = str.toCharArray();
		Arrays.sort(array);
		
		for (int i = 0; i < array.length-1; i++) {
			if (array[i] == array[i+1]) return false;
		}
		
		return true;
	}
	
	static String reverse(char [] str) {
		if (str == null) return null;
		
		int low = 0, high = str.length - 1;
		
		while(low < high) {
			char temp = str[low];
			str[low] = str[high];
			str[high] = temp;
			
			low++;
			high--;
		}
		
		return new String(str);
	}
	
	static boolean isPermutation(String str1, String str2) {
		if (str1 == null || str2 == null) return false;
		
		if (str1.length() != str2.length()) return false;
		
		int m = 0, n = 0;
		
		for (int i = 0; i < str1.length(); i++) {
			int val = str1.charAt(i) - 'a';
			m = m | (1 << val);
		}
		
		for (int i = 0; i < str2.length(); i++) {
			int val = str2.charAt(i) - 'a';
			n = n | (1 << val);
		}
		
		if ( (m ^ n) == 0 ) return true;
		
		return false;
	}
	
	static String compress(String str) {
		if (str == null) return null;
		StringBuffer buffer = new StringBuffer();
		int count = 1;
		
		char lastFound = str.charAt(0);

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == lastFound) {
				count++;
			} else {
				buffer.append(lastFound);
				buffer.append(count);
				lastFound = str.charAt(i);
				count = 1;
			}
		}
		
		buffer.append(lastFound);
		buffer.append(count);
		
		return buffer.toString();
		
	}
	
	/*
	 * Brute force method
	 */	
	static boolean hasSubstring(String str, String pattern) {
		if (str == null || pattern == null) return false;
		
		int k = 0, i=0, j=0;
		
		while(i < str.length() && j < pattern.length()) {
			if (str.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else {
				j = 0;
				k++;
				i = k;
			}
		}
		if (j == pattern.length()) {
			return true;
		}
		
		return false;
		
	}

	public static void main(String[] args) {
		System.out.println(hasSubstring("a", ""));
	}

}







