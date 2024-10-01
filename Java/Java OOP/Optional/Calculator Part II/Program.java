
public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c = new Calculator();
		
		c.addNumber(5);
		c.addOperator("+");
		c.addNumber(5);
		c.addOperator("-");
		c.addNumber(10);
		c.addOperator("*");
		c.addNumber(2);
		c.addOperator("/");
		c.addNumber(2);
		c.evaluate();
	}

}
