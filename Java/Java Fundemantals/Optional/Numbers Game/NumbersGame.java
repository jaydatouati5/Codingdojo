import java.util.Random;
public class NumbersGame {
    public static void main(String[] args){
        System.out.println("Hello, human. I am thinking of a number between 0 and 10.");
        System.out.println("*********************************************************");

        int answer = new Random().nextInt(0,11);

        int attempts = 3;
        while(true){
            if (attempts == 0){
                System.out.println("You ran out of attempts!");
                break;
            }
            
            System.out.printf("Can you guess the number?(%d attempts left)\n" , attempts);
            attempts--;
            System.out.println("If you are not up to the task, you can always type 'q' to quit.");
            String guess = System.console().readLine();
            if(guess.equals("q")){
                System.out.println("I knew you didn't have it in you.");
                System.out.println("Shutting down...");
                break;
            }

            try {
                Integer guessedNumber = Integer.parseInt(guess);
                if ((guessedNumber >= 0) && (guessedNumber <= 10)){
                    if(guessedNumber==answer){
                        System.out.println("Lucky guess! But can you do it again?");
                        break;
                    }else{
                        System.out.println("Swing and a miss! Keep trying...");
                    }
                }else{
                    System.out.printf("Only numbers between 0 and 10 are valid, %d isn't valid \n" , guessedNumber);
                }
            }catch(Exception e){
                System.out.printf("The value of '%s' that you have entered isn't a number or 'q', please try again!\n" , guess);
            }

            
        }
        System.out.println("Game over. Shutting down...");
    }
}

