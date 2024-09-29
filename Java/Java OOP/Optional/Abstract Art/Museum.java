import java.util.ArrayList;
import java.util.Collections;
public class Museum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Painting P1 = new Painting();
		Painting P2 = new Painting();
		Painting P3 = new Painting();
		

		Sculpture S1 = new Sculpture();
		Sculpture S2 = new Sculpture();
		
		// Ninja Bonus 1 :
		ArrayList<Art> museum = new ArrayList<Art> ();
		museum.add(P1);
		museum.add(P2);
		museum.add(P3);
		
		museum.add(S1);
		museum.add(S2);
		
		// Ninja Bonus 2 :
		Collections.shuffle(museum);
		for(Art artWork : museum) {
			artWork.viewArt();
		}
	}

}
