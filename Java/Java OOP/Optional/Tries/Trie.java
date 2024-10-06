import java.util.Set;

public class Trie {
	public Node root;
	
	
	public Trie() {
		this.root = new Node();
	}
	
	// Add a word to the trie
	public void addWord(String word) {
		Node current = this.root;
		int index = 0;
		while(index < word.length()) {
			char c = word.charAt(index);
			Node child = current.children.get(c);
			if (child == null) {
				child = new Node();
				current.children.put(c, child);
			}
			current = child;
			index++;
		}
		current.isWord = true;
	}
	
	public boolean isPrefixValid(String prefix) {
		Node current = this.root;
		for(int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			Node child = current.children.get(c);
			if(child == null) {
				return false;
			}
			current = child;
		}
		return true;
	}
	
	public boolean isWordValid(String word) {
		Node current = this.root;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			Node child = current.children.get(c);
			if(child == null) {
				return false;
			}
			current = child;
		}
		return current.isWord;
	}
	
	public void printAllKeys(Node t , String indentation) {
		if (t.children.isEmpty()) {
			return;
		}else {
			Set<Character> set = t.children.keySet();
			for(Character c : set) {
				System.out.println("└"+indentation+c);
				this.printAllKeys(t.children.get(c) , indentation + "─────");
			}
		}
	}
}
