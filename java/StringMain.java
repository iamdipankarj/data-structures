public class StringMain {
	
	// Check if compressed string greater length
	public static int countCompression(String str) {
		// Base cases
		if (str == null || str.isEmpty()) return 0;
		char first = str.charAt(0);
		int size = 0, count = 1;
		for(int i = 1; i < str.length(); ++i) {
			if (str.charAt(i) == first) {
				count++;
			} else {
				first = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
	
	public static String compress(String str) {
		int size = countCompression(str);
		if (size > str.length()) {
			return str;
		}
		
		StringBuffer result = new StringBuffer();
		char first = str.charAt(0);
		int count = 1;
		for(int i = 1; i < str.length(); ++i) {
			if (str.charAt(i) == first) {
				count++;
			} else {
				result.append(first);
				result.append(count);
				first = str.charAt(i);
				count = 1;
			}
		}
		result.append(first);
		result.append(count);
		
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(compress("abcc"));
	}

}
