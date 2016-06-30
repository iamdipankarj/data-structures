import java.util.*;

/*
 * Trie data structure.
 */
public class Trie {
	private TrieNode root;
	private int size;
	
	// Constructor
	public Trie() {
		root = new TrieNode((char)0);
		size = 0;
	}
	
	// Get count of words
	public int size() {
		return size;
	}
	
	// Method to insert word in a trie
	public void add(String word) {
		
		TrieNode crawl = root, temp; // Crawler for the root TrieNode
		HashMap<Character, TrieNode> child = crawl.children; // Temporary child
		char ch; // Temporary char to hold the current character
		
		// Traverse through all the character of the given word
		for (int i = 0; i < word.length(); i++) {
			
			ch = word.charAt(i); // Get the current character from the word
			child = crawl.children;
			
			// If child hashmap contains the current character

			if ( child.containsKey(ch) ) {
				crawl = child.get(ch);
			} else {
				
				// If hashmap child doesn't contain the current character
				temp = new TrieNode(ch);
				child.put(ch, temp);
				crawl = temp;
			}
		}
		
		crawl.isEnd = true;
		this.size++;
	}
	
	//  Method to search a word
	public boolean search(String word) {
		TrieNode crawl = root; // Crawler for the root TrieNode
		HashMap<Character, TrieNode> child = crawl.children; // Temporary child
		char ch; // Temporary char to hold the current character
		for ( int i = 0; i < word.length(); ++i) {
			ch = word.charAt(i);
			child = crawl.children;
			
			if ( ! child.containsKey(ch) ) {
				return false;
			} else {
				crawl = child.get(ch);
			}
		}
		if ( child.get(word.charAt(word.length()-1)).isEnd )			
			return true;
		return false;
	}
	
	// Method to delete word
	public void delete(String word) {
		TrieNode crawl = root; // Crawler for the root TrieNode
		HashMap<Character, TrieNode> child = crawl.children; // Temporary child
		char ch; // Temporary char to hold the current character
		
		// Iterate through each character to find the word
		for (int i = 0; i < word.length(); ++i) {
			ch = word.charAt(i); // Get current character from the word
			child = crawl.children;
			
			if ( child.containsKey(ch) ) {
				crawl = child.get(ch);
			} else {
				return;
			}
		}
		
		// Now we are at the last character
		if ( crawl.children.isEmpty() ) {
			child.clear();
			this.size--;

		} else if ( child.get(word.charAt(word.length()-1)).isEnd ) {
			child.get(word.charAt(word.length()-1)).isEnd = false;
			this.size--;
		}
		
	}
}



