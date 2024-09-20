import java.util.ArrayList;
public class CafeUtil{
    public int getStreakGoal(){
        int week = 10;
        int total = 0;

        for (int i = 1; i <= week; i++){
            total += i;
        }

        return total;
    }

    /*
     * i = 0 | total = 0
     * i = 0 | total = 3.5
     * i = 1 | total = 5
     * i = 2 | total = 9
     * i = 3 | total = 13.5
     * i = 4 | total = 13.5
     */ 

    // prices = {3.5, 1.5, 4.0, 4.5}
    public double getOrderTotal(double[] prices){
        double total = 0;

        // ! Classic For Loop
        // for (int i = 0; i < prices.length; i++){
        //     total += prices[i];  // total = total + prices[i] => total = 0 + prices[0] => total = 0 + 3.5
        // }

        // ! Enhanced For Loop
        for (double price : prices){
            total += price;
        }

        return total;
    }
    /*
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
     */
    public void displayMenu(ArrayList<String> menuItems){
        for (int i = 0; i < menuItems.size(); i++){
            System.out.println(i + " - " + menuItems.get(i));
        }
    }


    public void addCustomer(ArrayList<String> customers){
        System.out.print("Please enter your name: ");
        String username = System.console().readLine();
        System.out.println("Hello, " + username + "!");
        System.out.println("There are " + customers.size() + " people in front of you");
        customers.add(username);
        System.out.println(customers);
    }

    // ! Ninja Bonus 1
    public void printPriceChart(String product, double price, int maxQuantity){
        System.out.println(product);
        double total = 0;
        for (int i = 1; i <= maxQuantity; i++){
            total += price;
            // System.out.println(i + " - $" + total);
            // ! Ninja Bonus 2
            System.out.format("%d - $%.2f\n" , i , total);
            price -= 0.5;
        }
    }

    // ! Ninja Bonus 3
    public boolean displayMenu(ArrayList<String> menuItems , ArrayList<Double> prices){
        if (menuItems.size() != prices.size()){
            return false;
        }

        for (int i = 0; i < menuItems.size(); i++){
            System.out.format("%d %s -- $%.2f\n" , i , menuItems.get(i) , prices.get(i));
        }

        return true;
    }
}