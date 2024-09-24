import java.util.ArrayList;

public class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item>items;

    public Order(){
        this("Guest");
    }

    public Order(String name){
        this.name = name ;
        this.items = new ArrayList<Item>();
        
    }

    // Getters & Setters for our member variables :
    //! Getter for name
    public String getName(){
        return this.name;
    }

    //! Setter for name
    public void setName(String name){
        this.name = name;
    }
    // -------------------------------------------------------------------------------------------

    //! Getter for ready
    public boolean isReady(){
        return this.ready;
    }

    //! Setter for ready
    public void setReady(boolean ready){
        this.ready = ready;
    }
    // -------------------------------------------------------------------------------------------

    //! Getter for items
    public ArrayList<Item> getItems(){
        return this.items;
    }

    //! Setter for items
    public void setItems (ArrayList<Item> items){
        this.items = items;
    }
    // -------------------------------------------------------------------------------------------

    public void addItem(Item item){
        this.items.add(item);
    }

    public String getStatusMessage(){
        return this.ready ? "Your order is ready." : "Thank you for waiting. Your order will be ready soon.";
    }

    public double getOrderTotal(){
        double total = 0;
        for(int i=0 ; i<this.items.size() ; i++){
            total += this.items.get(i).getPrice();
        }
        return total;
    }

    public void display(){
        System.out.printf("Customer Name : %s \n " , this.name);
        for(int i=0 ; i<this.items.size(); i++){
            System.out.println(this.items.get(i).getName() + " - $" + this.items.get(i).getPrice());
        }
        System.out.println("total : $" + this.getOrderTotal());
    }

    
}

