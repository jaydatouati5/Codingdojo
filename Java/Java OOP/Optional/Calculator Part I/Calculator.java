import java.io.Serializable;

public class Calculator implements Serializable {
	private double operandOne;
	private String operation;
	private double operandTwo;
	private double result;
	
	public Calculator() {
	}
	
	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	

	public double getResult() {
		return this.result;
	}
	
	public void performOperation() {
		if(this.operation =="+") {
			this.result = this.operandOne + this.operandTwo;
		}else {
			this.result = this.operandOne - this.operandTwo;
		}
	}
}
