import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {
	ArrayList<Object> list;
	double results;
	
	public Calculator() {
		this.list = new ArrayList<Object>();
	}
	
	public void addNumber(double num) {
		this.list.add(num);
	}
	
	public void addOperator(String op) {
		this.list.add(op);
	}
	
	public double getResults() {
		return this.results;
	}
	
	public double calculate(double num1 , String op , double num2) {		
		return switch(op) {
			case "+" -> num1 + num2;
			case "-" -> num1 - num2;
			case "*" -> num1 * num2;
			default -> num1 / num2;
		};
	}
	
	public void evaluate() {
		ArrayList<Object> newList = new ArrayList<Object>(this.list);
		for(Object val : this.list) {
			System.out.printf("%s " , val);
		}
		System.out.print("= ?\n");
		ArrayList<String> opOrder = new ArrayList<String>(Arrays.asList("*" , "/" , "+" , "-"));
		int i = 0;
		int index = this.list.indexOf(opOrder.get(i));
		// Multiplication
		while(i < opOrder.size()) {
			index = this.list.indexOf(opOrder.get(i));
			if(index == -1) {
				i++;
//				index = this.list.indexOf(opOrder.get(i));
				continue;
			}
			double num1 = (Double)this.list.get(index - 1);
			double num2 = (Double)this.list.get(index + 1);
			double result = this.calculate(num1, opOrder.get(i), num2);
			this.list.remove(index - 1);
			index--;
			this.list.remove(index + 1);
			this.list.set(index, result);
			for(Object val : this.list) {
				System.out.printf("%s " , val);
			}
			System.out.print("= ?\n");
		}
		for(Object val : newList) {
			System.out.printf("%s " , val);
		}
		this.results = (Double)this.list.get(0);
		System.out.printf("= %.2f" , this.results);
		this.list = new ArrayList<Object>();
	}

}
