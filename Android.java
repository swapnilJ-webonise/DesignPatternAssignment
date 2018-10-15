
public class Android extends Cellphone implements Connection,multimedia{

	@Override
	int makeCall(int simno, String contactname) {
		System.out.println("You are calling from "+simno+" to "+contactname);
		return 1;
	}

	@Override
	void sendMessage(int simno, String contactname) {
		System.out.println("You are messaging from "+simno+" to "+contactname);		
	}

	@Override
	public void recordVideo() {
		System.out.println("You are recording video...");

		
	}

	@Override
	public void takePhoto() {
		System.out.println("You are taking photo");		
	}

	@Override
	public void bluetooth() {
		System.out.println("Bluetooth in on");		
	}
	
	void openPlaystore() {
		System.out.println("Opening Play Store");
	}
	
	int printMessage(String msg) {
		System.out.println(msg);
		return 0;
	}
	

}
