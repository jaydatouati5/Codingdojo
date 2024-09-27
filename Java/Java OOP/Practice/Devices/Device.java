
public class Device {
	protected int battery = 100;
	
	public void status() {
		System.out.printf("Battery remaining : %d\n", this.battery);
	}
	
	public void modifyBattery(int amount) {
		this.battery +=amount;
		if (this.battery < 0) {
			this.battery = 0;
		}else if (this.battery > 100) {
			this.battery = 100;
		}
	}
	
}
