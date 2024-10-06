
public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie t = new Trie();
		
		t.addWord("car");
		t.addWord("card");
		t.addWord("cars");
		t.addWord("cheap");
		t.addWord("cards");
		
		System.out.println(t.isWordValid("cheap"));
		
		t.printAllKeys(t.root , "");
	}

}
