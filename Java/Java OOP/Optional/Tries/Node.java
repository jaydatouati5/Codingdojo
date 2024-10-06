import java.util.HashMap;

public class Node {
	HashMap<Character, Node> children;
	boolean isWord;
	
	public Node() {
		this.children = new HashMap<Character, Node>();
	}
}
