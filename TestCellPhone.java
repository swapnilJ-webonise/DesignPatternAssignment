
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestCellPhone {

	static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int choice, choice2;
		int simno, m;
		do {
			System.out.println("");
			System.out.println("1)NOKIA ASHA 101");
			System.out.println("2)PIXEL");
			System.out.println("3)IPHONE");
			System.out.println("4)FOR EXIT, PRESS 0");
			choice = Integer.parseInt(sc.readLine());
			switch (choice) {
			case 1: do{
				System.out.println(	"Features: \n 1) Make a call(Dual Sim) \n 2) Send Message \n 3) open Bluetooth\n 4) Start a Torch\n 5) Choose feature to use (FOR EXIT, PRESS 0):");
				choice2 = Integer.parseInt(sc.readLine());
				featurPhoneChoice(choice2);
			}while(choice2 != 0);
			break;
			
			case 2: do{
				System.out.println(	"Features: \n 1) Make a call(Dual Sim) \n 2) Send Message \n 3) open PlayStore\n 4) Take Photo\n 5) Choose feature to use (FOR EXIT, PRESS 0):");
				choice2 = Integer.parseInt(sc.readLine());
				androidChoice(choice2);
			}while(choice2 != 0);
			break;
			
			case 3: do{
				System.out.println(	"Features: \n 1) Make a call \n 2) Send Message \n 3) open Open App Store\n 4) Record a Video\n 5) Choose feature to use (FOR EXIT, PRESS 0):");
				choice2 = Integer.parseInt(sc.readLine());
				iOSChoice(choice2);
			}while(choice2 != 0);
			break;
			

	}

}while(choice != 0);
}
	
	
	
static void androidChoice(int choice) throws IOException {
	Android android = new Android();
		switch(choice) {
		case 1: 
			System.out.println("Whom to Call : ");
			String name = sc.readLine();
			System.out.println("Sim No : ");
			int simno = Integer.parseInt(sc.readLine());
			int m = (simno <= 2) ? android.makeCall(simno, name) : android.printMessage("Not able to call..!");
			break;
		case 2:
			System.out.println("Whom to send message : ");
			name = sc.readLine();
			System.out.println("Sim No : ");
			simno = Integer.parseInt(sc.readLine());
			android.sendMessage(simno,name);
			break;
		case 3:
			android.openPlaystore();
			break;
		case 4:
			android.takePhoto();
			break;
		}
	}


static void iOSChoice(int choice) throws IOException {
	IOs ios = new IOs();
		switch(choice) {
		case 1: 
			System.out.println("Whom to Call : ");
			String name = sc.readLine();
			System.out.println("Sim No : ");
			int simno = Integer.parseInt(sc.readLine());
			int m = (simno <= 2) ? ios.makeCall(simno, name) : ios.printMessage("Not able to call..!");
			break;
		case 2:
			System.out.println("Whom to send message : ");
			name = sc.readLine();
			System.out.println("Sim No : ");
			simno = Integer.parseInt(sc.readLine());
			ios.sendMessage(simno,name);
			break;
		case 3:
			ios.openAppStore();
			break;
		case 4:
			ios.recordVideo();
			break;
		}
	
}


static void featurPhoneChoice(int choice) throws IOException {
	FeaturePhone feature = new FeaturePhone();
		switch(choice) {
		case 1: 
			System.out.println("Whom to Call : ");
			String name = sc.readLine();
			System.out.println("Sim No : ");
			int simno = Integer.parseInt(sc.readLine());
			int m = (simno <= 2) ? feature.makeCall(simno, name) : feature.printMessage("Not able to call..!");
			break;
		case 2:
			System.out.println("Whom to send message : ");
			name = sc.readLine();
			System.out.println("Sim No : ");
			simno = Integer.parseInt(sc.readLine());
			feature.sendMessage(simno,name);
			break;
		case 3:
			feature.bluetooth();break;
		case 4:
			feature.openTorch();break;
		
		}
	}
}
