import java.util.ArrayList;
import java.util.Random;
public class TestPuzzleJava {
    
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();
		ArrayList<Integer> randomRolls = generator.getTenRolls();
		System.out.println(randomRolls);
		
		char randomChar = generator.getRandomLetter();
		System.out.println(randomChar);

		String password = generator.generatePassword();
		System.out.println(password);

		ArrayList<String> passwords = generator.getNewPasswordSet(10);
		System.out.println(passwords);

		ArrayList<Object> array = new ArrayList<Object>();
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		array.add(5);
		array.add(6);
		array.add(7);
		array.add(8);
		array.add(9);
		array.add(10);
		System.out.print("Array before shuffling: ");
		System.out.println(array);

		generator.shuffle(array);
		
		System.out.print("Array after shuffling: ");
		System.out.println(array);
    	//..
		// Write your other test cases here.
		//..
	}
}
