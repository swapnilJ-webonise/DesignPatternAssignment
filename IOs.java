
public class IOs extends Cellphone implements multimedia{

	@Override
	int makeCall(int simno, String contactname) {
		if(simno == 1)
		{
			System.out.println("You are calling from "+simno+" to "+contactname);
			return 1;
		}else {
			System.out.println("You cannot make call from"+simno);
		}
		return 0;
		
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
	
	void openAppStore() {
		System.out.println("Opening App Store");
	}
	int printMessage(String msg) {
		System.out.println(msg);
		return 0;
	}
}
