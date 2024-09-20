import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava{
    Random r = new Random();

    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> numbersArray = new ArrayList<Integer>();
        // Integer randomNumber;
        for (int i = 0; i < 10; i++){
            // randomNumber = r.nextInt(20) + 1;
            // numbersArray.add(randomNumber);

            // ! Less Code More Efficient
            numbersArray.add(r.nextInt(20) + 1);
        }
        return numbersArray;
    }

    public char getRandomLetter(){
        // ! First Try
        // int randomNumber = r.nextInt(26);
        // int charAsciCode = randomNumber + 97;
        // char finalChar = (char) charAsciCode;
        // return finalChar;

        // ! Second Try
        // return (char) (r.nextInt(26) + 97);

        // ! Third Try
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        return alphabet[r.nextInt(26)];
    }

    public String generatePassword(){
        String password = "";
        for (int i = 0; i < 8; i++){
            password += getRandomLetter();
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int length){
        ArrayList<String> passwords = new ArrayList<String>();
        
        for (int i = 0; i < length; i++){
            passwords.add(generatePassword());
        }

        return passwords;
    }

    // ! Sensei Bonus
    public void shuffle(ArrayList<Object> array){
        for (int i = 0; i < array.size(); i++){
            // Choose new Position for element
            int newPosition = r.nextInt(array.size());

            // ! Swapping element at index i with element at index newPosition
            // Store element at index i in temp variable
            Object temp = array.get(i);

            // Set element at index i to the element at index newPosition
            array.set(i, array.get(newPosition));

            // Set element at index newPosition to temp
            array.set(newPosition, temp);
        }
    }
}