public class Test {
    public static void main(String[] args) {
        Order order1 = new Order();
        Order order2 = new Order();

        Order order3 = new Order("Jayda");
        Order order4 = new Order("John");
        Order order5 = new Order("Sam");


        order1.addItem(new Item("Table",200));
        order1.addItem(new Item("pc", 2220));

        order2.addItem(new Item("chair",80));
        order2.addItem(new Item("hammer", 40));

        order3.addItem(new Item("fan",100));
        order3.addItem(new Item("studio_light",1200 ));

        order4.addItem(new Item("tv",2500));
        order4.addItem(new Item("playstation", 2500));
        

        order5.addItem(new Item("phone",2200));
        order5.addItem(new Item("tablet", 1600));

        order1.setReady(true);
        order2.setReady(true);
        System.out.println(order1.getStatusMessage());
        System.out.println(order2.getStatusMessage());
        System.out.println(order3.getStatusMessage());
        System.out.println(order4.getStatusMessage());
        System.out.println(order5.getStatusMessage());

        System.out.println(order1.getOrderTotal());


        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();
    }
}
