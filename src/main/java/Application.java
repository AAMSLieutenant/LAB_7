import Parsers.JAXBParser;
import Parsers.SAX;
import Parsers.STAX;
import steelArms.Handy;
import steelArms.SteelArm;
import steelArms.Type;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Application {
    public static void main(String[] args) {
        Logger log= Logger.getLogger(Application.class);
        try{


            PropertyConfigurator.configure("log4j.properties");

            log.info("Application started");

            SteelArm steelarm=new SteelArm();
            steelarm.setBladeLength(50);
            steelarm.setBladeWidth(3.6);
            steelarm.setBloodFlow(true);
            steelarm.setCollectible(true);
            steelarm.setHandle("wood");
            steelarm.setHandy(Handy.TWO);
            steelarm.setMaterial("steel");
            steelarm.setOrigin("USA");
            steelarm.setType(Type.DAGGER);

    //        JAXBParser parser=new JAXBParser();
//           JAXBParser.readXML("TEST_WEAPON_FILE.xml");
//            JAXBParser.insertXML(steelarm, "TEST_WEAPON_FILE.xml");


//            SAX.parse("TEST_WEAPON_FILE.xml");
            STAX.parse("TEST_WEAPON_FILE.xml");

      }
      catch(Exception e){
            log.error("Application error");
            e.printStackTrace();
      }

    }
}
