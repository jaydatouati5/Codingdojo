
public class Phone extends Device{
	public void makeCall() {
		this.modifyBattery(-5);
		System.out.println("You made a phone call!");
		this.status();
		if(this.battery<10) {
			System.out.println("Battery critical");
		}
	}
	
	public void playGame() {
		if(this.battery<25) {
			System.out.println("You can't play game!");
		}else {
			this.modifyBattery(-20);
			System.out.println("You play a game!");
			this.status();
			if(this.battery<10) {
				System.out.println("Battery critical");
			}
		}
	}
	
	public void charge() {
		this.modifyBattery(50);
		System.out.println("You're charging your phone!");
		this.status();
	}
	
	
	
	
}
