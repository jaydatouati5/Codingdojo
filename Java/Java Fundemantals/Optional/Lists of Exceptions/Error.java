import java.util.ArrayList;
public class Error {
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        for(int i = 0; i < myList.size(); i++) {
            try {
                Integer castedValue = (int) myList.get(i);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Could not cast it !");
                System.out.println(i);
                System.out.println(myList.get(i));
            }
        }
    }
}