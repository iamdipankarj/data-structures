import java.util.*;

public class DP {
	
	static String breakWord(String word, Set<String> dict) {
		
		int n = word.length();
		int[][] dp = new int[n][n];
		
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		
		for (int len = 1; len <= n; len++) {
			for (int charIndex = 0; charIndex < n-len+1; charIndex++) {
				int j = charIndex + len - 1;
				String str = word.substring(charIndex, j+1);
				if (dict.contains(str)) {
					dp[charIndex][j] = charIndex;
					continue;
				}
				
				for (int splitIndex = charIndex+1 ; splitIndex <= j; splitIndex++) {
					if (dp[charIndex][splitIndex-1] != -1 && dp[splitIndex][j] != -1) {
						dp[charIndex][j] = splitIndex;
						break;
					}
				}
				
			}
		}
		
		if (dp[0][n-1] == -1) return null;
		
		// create the word
		StringBuffer buffer = new StringBuffer();
		int i=0, j = n-1;
		while (i < j) {
			int k = dp[i][j];
			if (i == k) {
				buffer.append(word.substring(i, j+1));
				break;
			}
			buffer.append(word.substring(i, k) + " ");
			i = k;
		}
		
		return buffer.toString();
	}
	
	public static void main(String[] args) {
	}

}
