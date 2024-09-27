
public class Bat extends Mammal{

	public Bat() {
		this.energy = 300;
	}
	
	public void fly() {
		this.energy-=50;
		System.out.println("the bat is airborne!");
	}
	
	public void eatHumans() {
		this.energy+=25;
		System.out.println("the bat is happy!");
	}
	
	public void attackTown() {
		this.energy-=100;
		System.out.println("It was strong attack!");
	}
	
}
