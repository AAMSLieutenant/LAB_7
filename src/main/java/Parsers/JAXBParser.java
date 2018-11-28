package Parsers;
import steelArms.Handy;
import steelArms.SteelArms;
import steelArms.Type;
import steelArms.SteelArm;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;

public class JAXBParser {

    private Handy handy;
    private Type type;
    private String origin;
    private boolean collectible;
    private double bladeLength;
    private double bladeWidth;
    private String material;
    private String handle;
    private boolean bloodFlow;

    private static final Logger log= Logger.getLogger(JAXBParser.class);
    static {
        PropertyConfigurator.configure("log4j.properties");
    }



    public static void insertXML(SteelArm myObj, String FILE){

        log.info("JAXB insert started");
        SteelArms w=readXML("TEST_WEAPON_FILE.xml");
//        w.setArr(new ArrayList<SteelArm>());
        //SteelArms test=readXML("TEST_WEAPON_FILE.xml");
        w.getArr().add(myObj);

        try{
            File file = new File(FILE);
            JAXBContext jaxbContext = JAXBContext.newInstance(SteelArms.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(w, file);
            jaxbMarshaller.marshal(w, System.out);
            System.out.println("-----------");
        }
        catch (JAXBException e) {
            log.info("insertXML error");
            e.printStackTrace();
        }
    }


    public static SteelArms readXML(String FILE){
        try{

            log.info("JAXB read started");
            File file = new File(FILE);
            JAXBContext jaxbContext = JAXBContext.newInstance(SteelArms.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            SteelArms weapons = (SteelArms) jaxbUnmarshaller.unmarshal( file );

            for(SteelArm sta : weapons.getArr())
            {
                System.out.println(sta.toString());
            }
            return weapons;
        }
        catch (JAXBException e) {
            log.info("readXML error");
            e.printStackTrace();
        }
        return null;
    }


}
