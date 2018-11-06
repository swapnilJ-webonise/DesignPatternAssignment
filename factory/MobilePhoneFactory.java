package factory;

import java.io.IOException;
import base.Android;
import base.FeaturePhone;
import base.Ios;
import base.MobilePhone;

public class MobilePhoneFactory {

  int choice;
 
  public MobilePhone createMobile(int choice) throws NumberFormatException, IOException {
    switch(choice) {
      case 1:return new FeaturePhone();
      case 2:return new Android();
      case 3:return new Ios();
      default : System.out.println("Oh ho, Wrong input..!!");
      }
    return null;
  }
}