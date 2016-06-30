import java.util.HashMap;

public class TrieNode {
	public char value;
	public HashMap<Character, TrieNode> children;
	public boolean isEnd;
	public TrieNode(char val) {
		value = val;
		isEnd = false;
		children = new HashMap<>();
	}
}
