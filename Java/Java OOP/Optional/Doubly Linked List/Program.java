
public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DLL d = new DLL();
		
		d.push(5);
		d.push(10);
		d.push(5);
		System.out.println("--------------");
		d.printValuesForward();
		d.insertAt(11, 1);
		d.insertAt(11, 3);
		d.insertAt(12, 3);
		d.removeAt(3);
		System.out.println("--------------");
		d.printValuesForward();
		System.out.println(d.isPalindrome());
	}

}
