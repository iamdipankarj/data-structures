import java.util.*;

public class SuffixTreeNode {
	
	// The character
	public char value;
	
	// children Hashmap	
	public HashMap<Character, SuffixTreeNode> children;
	
	// Arraylist of integers
	public ArrayList<Integer> indexes;
	
	public SuffixTreeNode() {
		children = new HashMap<>();
		indexes = new ArrayList<>();
	}
	
	// Method to insert a new string
	public void insertString(String s, int index) {
		indexes.add(index);
		
		// Check if a string exists
		if (s != null && s.length() > 0) {
			
			// get the first character
			value = s.charAt(0);
			
			// Create an empty child at node
			SuffixTreeNode child = null;
			if (children.containsKey(value)) {
				child = children.get(value);
			} else {
				child = new SuffixTreeNode();
				children.put(value, child);
			}
			
			// Get string excluding first character
			String remainder = s.substring(1);
			
			// Recursively insert the string excluding first character until
			// there's an empty string
			child.insertString(remainder, index);
		}
	}
	
	public ArrayList<Integer> getIndexes(String s) {
		if (s == null || s.length() == 0) {
			return indexes;
		} else {
			char first = s.charAt(0);
			if (children.containsKey(first)) {
				String remainder = s.substring(1);
				return children.get(first).getIndexes(remainder);
			}
		}
		return null;
	}
}


