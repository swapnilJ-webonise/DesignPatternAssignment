
public class FeaturePhone extends Cellphone implements Connection{

	@Override
	int makeCall(int simno,String contactname) {
		System.out.println("You are calling from "+simno+" to "+contactname);
	return 1;	
	}

	@Override
	void sendMessage(int simno,String contactname) {
		System.out.println("You are messaging from "+simno+" to "+contactname);
	}
	
	void openTorch() {
		System.out.println("Opening Torch.");
		
	}

	@Override
	public void bluetooth() {
		System.out.println("Bluetooth in on");
		
	}
	int printMessage(String msg) {
		System.out.println(msg);
		return 0;
	}
}
