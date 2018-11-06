package mainPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import base.Android;
import base.FeaturePhone;
import base.Ios;
import base.MobilePhone;
import factory.MobilePhoneFactory;
import strategy.PaymentByPaytmApp;
import strategy.PaymentByTezApp;

public class MainMobilePhone {
  static int choice;
  static int simno;
  static String contactName;
  static BufferedReader getMobileRequest = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
    MobilePhoneFactory mobileFactory = new MobilePhoneFactory();
    do {
      System.out.println("1)NOKIA ASHA 101");
      System.out.println("2)PIXEL");
      System.out.println("3)IPHONE");
      System.out.println("Which type of mobile you want,Please Enter a number :");
      choice = Integer.parseInt(getMobileRequest.readLine());
      if (choice != 0 && choice < 4) {
        MobilePhone mobile = mobileFactory.createMobile(choice);
        operations(mobile);
      }
    } while (choice != 0);
  }

  public static void operations(MobilePhone mobileOperation)
      throws NumberFormatException, IOException, InterruptedException {

    if (choice == 1) {
    	
      int operationChoice;
      FeaturePhone featurePhone = new FeaturePhone();
      do {
        operationChoice = featurePhone.featurePhoneOperations();
        if (operationChoice == 1) {
          userInteraction();
          featurePhone.makeCall(simno, contactName);
        }
        if (operationChoice == 2) {
          userInteraction();
          featurePhone.sendMessage(simno, contactName);
        }
        if (operationChoice == 3) {
          featurePhone.bluetooth();
        }
        if (operationChoice == 4) {
          featurePhone.openTorch();
        }

      } while (operationChoice != 0);
    }
    if (choice == 2) {

      int operationChoice;
      Android android = new Android();
      ArrayList<String> appList = new ArrayList<String>();
      do {
        operationChoice = android.androidOperations();
        if (operationChoice == 1) {
          userInteraction();
          android.makeCall(simno, contactName);
        }
        if (operationChoice == 2) {
          userInteraction();
          android.sendMessage(simno, contactName);
        }
        if (operationChoice == 3) {
          android.recordVideo();
        }
        if (operationChoice == 4) {
          android.openPlaystore();
        }
        if (operationChoice == 5) {
          System.out.println("Which App You want to install :");
          String appName = getMobileRequest.readLine();
          appList.add(android.installApp(appName));
        }
        if (operationChoice == 6) {
          System.out.println("Which app You want to Uninstall: ");
          String appName = getMobileRequest.readLine();
          appList.remove(android.unInstallApp(appName));
        }
        if (operationChoice == 7) {
          System.out.println("Android Application List:");
          for (int appno = 0; appno < appList.size(); appno++) {
            System.out.println((appno + 1) + " " + appList.get(appno));
          }

        }
        
        if (operationChoice == 8) {
          System.out.print("Which app you want use for pay: ");
          String appName = getMobileRequest.readLine();
          if (checkAppAvailability(appName, appList)) {
            System.out.print("How much money you want to pay: ");
            double amount = Double.parseDouble(getMobileRequest.readLine());
            switch (appName) {
            case "paytm":
              android.setAndroidPaymentStrategy(new PaymentByPaytmApp());
              android.doPaymentFromAndroid(amount);
              break;
            case "tez":
              android.setAndroidPaymentStrategy(new PaymentByTezApp());
              android.doPaymentFromAndroid(amount);
              break;
            }

          } else {
            System.out.println("App is Not install!!");
          }

        }

      } while (operationChoice != 0);
    }
    
    if (choice == 3) {
      int operationChoice;
      Ios ios = new Ios();
      ArrayList<String> appList = new ArrayList<String>();
      do {
        operationChoice = ios.iosOperations();
        if (operationChoice == 1) {
          userInteraction();
          ios.makeCall(simno, contactName);
        }
        if (operationChoice == 2) {
          userInteraction();
          ios.sendMessage(simno, contactName);
        }
        if (operationChoice == 3) {
          ios.recordVideo();
        }
        if (operationChoice == 4) {
          ios.openAppStore();
        }
        if (operationChoice == 5) {
          System.out.println("Which App You want to install :");
          String appName = getMobileRequest.readLine();
          appList.add(ios.installApp(appName));
        }
        if (operationChoice == 6) {
          System.out.println("Which app You want to Uninstall: ");
          String appName = getMobileRequest.readLine();
          appList.remove(ios.unInstallApp(appName));
        }
        if (operationChoice == 7) {
          System.out.println("IPhone Application List:");
          for (int appno = 0; appno < appList.size(); appno++) {
            System.out.println((appno + 1) + " " + appList.get(appno));
          }
        }
        if (operationChoice == 8) {
          System.out.print("Which app you want use for pay: ");
          String appName = getMobileRequest.readLine();
          if (checkAppAvailability(appName, appList)) {
            System.out.print("How much money you want to pay: ");
            double amount = Double.parseDouble(getMobileRequest.readLine());
            switch (appName) {
            case "paytm":
              ios.setAndroidPaymentStrategy(new PaymentByPaytmApp());
              ios.doPaymentFromAndroid(amount);
              break;
            case "tez":
              ios.setAndroidPaymentStrategy(new PaymentByTezApp());
              ios.doPaymentFromAndroid(amount);
              break;
            }

          } else {
            System.out.println("App is Not install!!");
          }

        }
      } while (operationChoice != 0);
    }
  }

  public static void userInteraction() throws NumberFormatException, IOException {
    BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Which sim you want to use : ");
    simno = Integer.parseInt(userInput.readLine());
    System.out.println("To whom (Person Name) : ");
    contactName = userInput.readLine();
  }

  static boolean checkAppAvailability(String appName, ArrayList<String> appList) {

    for (int appno = 0; appno < appList.size(); appno++) {
      if (appName.equals(appList.get(appno))) {
        return true;
      }
    }
    return false;
  }
}
