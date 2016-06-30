import java.util.ArrayList;

public class SuffixTree {
	public SuffixTreeNode root;
	
	public SuffixTree(String s) {
		root = new SuffixTreeNode();
		for (int i = 0; i < s.length(); ++i) {
			String suffix = s.substring(i);
			root.insertString(suffix, i);
		}
	}
	
	public ArrayList<Integer> getIndexes(String s) {
		return root.getIndexes(s);
	}
}
