import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        Item item4 = new Item();

        //!Item 1
        item1.name = "moucha";
        item1.price =3.5;

        //!Item 2
        item2.name = "late";
        item2.price =4.5;

        //!Item 3
        item3.name = "drip coffee";
        item3.price =3;

        //!Item 4
        item4.name ="cappuccino" ;
        item4.price =3.5;

        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();

        //! Order 1 
        order1.name = "Cindhuri";

        //! Order 2
        order2.name = "Jimmy";

        //! Order 3
        order3.name = "Noah";

        //! Order 4
        order4.name = "Sam";
    
        System.out.println(order1);
        order2.items.add(item1);
        order2.total += item1.price;
        order3.items.add(item4);
        order3.total += item4.price;
        order4.items.add(item2);
        order4.total += item2.price;
        order1.ready = true;
        order4.items.add(item2);
        order4.total += item2.price;
        order2.ready = true;
        // Application Simulations
        // Use this example code to test various orders' updates
        // System.out.printf("Name: %s\n", order1.name);
        // System.out.printf("Total: %s\n", order1.total);
        // System.out.printf("Ready: %s\n", order1.ready);
    }
}
