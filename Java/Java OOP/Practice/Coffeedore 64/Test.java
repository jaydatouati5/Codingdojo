public class Test {
    public static void main(String[] args) {
        CoffeeKiosk kiosk = new CoffeeKiosk();
        kiosk.addMenuItem("Milkshake", 10);
        kiosk.addMenuItem("Crepe", 7);
        kiosk.addMenuItem("waffle", 13);
        kiosk.addMenuItem("Cheesecake", 9);

        kiosk.newOrder();
    }
}
