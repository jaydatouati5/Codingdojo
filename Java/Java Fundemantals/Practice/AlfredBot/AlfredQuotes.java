import java.util.Date;
import java.util.Random;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return "Hello, "+name+". Lovely to see you.";
    }

    // ! Bonus Ninja 1
    public String guestGreeting(String name , String dayPeriod){
        return "Good "+ dayPeriod +", "+name+". Lovely to see you!";
    }

    // ! Bonus Ninja 2
    public String horrorGreeting(String name) {
        Random random = new Random();
        int delay = random.nextInt(5000);
        long msToAdd = delay * 1000L * 3600L * 24L;
        Date date = new Date();
        date.setTime(date.getTime() + msToAdd);
        return String.format("Hello %s, You will die on %s", name , date);
    }
    
    public String dateAnnouncement() {
        Date date = new Date();
        return "It is currently " + date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        if (conversation.indexOf("Alexis") != -1){
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }else if (conversation.indexOf("Alfred") != -1){
            return "At your service.";
        }else{
            return "Right. And with that I shall retire.";
        }
    }
    
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

