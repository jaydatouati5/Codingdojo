public class Item {
    private String name;
    private double price;

    public Item (String name , double price){
        this.name = name ;
        this.price = price;
    }

    // Getters & Setters for our member variables :

    //! Getter for name
    public String getName(){
        return this.name ;
    }

    //! Setter for name
    public void setName(String name){
        this.name = name;
    }
    // -------------------------------------------------------------------------------------------

    //! Getter for price
    public double getPrice(){
        return this.price;
    }

    //! Setter for price 
    public void setPrice(double price){
        this.price = price;
    }
        // -------------------------------------------------------------------------------------------

}