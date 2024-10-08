public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffee = 2.5;
        double latte = 3;
        double cappuccino = 5;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        // ! Cindhuri
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        // ! Noah
        System.out.println(generalGreeting + customer4);
        System.out.println(isReadyOrder1 ? customer1 + readyMessage : customer1 + pendingMessage);
        if (isReadyOrder4){
            System.out.println(customer4+readyMessage);
            System.out.println(displayTotalMessage+cappuccino);
        }else{
            System.out.println(customer4+pendingMessage);
        }
        // ! Sam
        System.out.println(generalGreeting + customer2);
        System.out.println(displayTotalMessage+latte*2);
        System.out.println(isReadyOrder2 ? customer2 + readyMessage : customer2 + pendingMessage);

        // ! Jimmy
        System.out.println(generalGreeting + customer3);
        System.out.println(displayTotalMessage+(dripCoffee-latte));
    }
}
