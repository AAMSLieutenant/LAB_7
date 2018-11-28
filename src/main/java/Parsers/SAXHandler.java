

package Parsers;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import steelArms.SteelArm;
import steelArms.Handy;
import steelArms.Type;

public class SAXHandler extends DefaultHandler {

    // List to hold Employees object
    private List<SteelArm> armList = null;
    private SteelArm arm = null;
    private StringBuilder data = null;



    boolean bHandy = false;
    boolean bType = false;
    boolean bOrigin = false;
    boolean bCollectible = false;
    boolean bBladeLength = false;
    boolean bBladeWidth = false;
    boolean bMaterial = false;
    boolean bHandle = false;
    boolean bBloodFlow = false;


//    private Handy handy;
//    private Type type;
//    private String origin;
//    private boolean collectible;
//    private double bladeLength;
//    private double bladeWidth;
//    private String material;
//    private String handle;
//    private boolean bloodFlow;

    // getter method for employee list
    public List<SteelArm> getArmList() {
        return armList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {



//



        if (qName.equalsIgnoreCase("steelarm")) {
            // create a new Employee and put it in Map

            arm = new SteelArm();
            // initialize list
            if (armList == null)
                armList = new ArrayList<SteelArm>();
        } else if (qName.equalsIgnoreCase("handy")) {
            // set boolean values for fields, will be used in setting Employee variables
            bHandy = true;
        } else if (qName.equalsIgnoreCase("type")) {
            bType = true;
        } else if (qName.equalsIgnoreCase("origin")) {
            bOrigin = true;
        } else if (qName.equalsIgnoreCase("collectible")) {
            bCollectible = true;
        }
        else if (qName.equalsIgnoreCase("bladelength")) {
            bBladeLength = true;
        }
        else if (qName.equalsIgnoreCase("material")) {
            bMaterial = true;
        }
        else if (qName.equalsIgnoreCase("bladewidth")) {
            bBladeWidth = true;
        }
        else if (qName.equalsIgnoreCase("handle")) {
            bHandle = true;
        }
        else if (qName.equalsIgnoreCase("bloodflow")) {
            bBloodFlow = true;
        }
        // create the data container
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

//        boolean bHandy = false;
//        boolean bType = false;
//        boolean bOrigin = false;
//        boolean bCollectible = false;
//        boolean bBladeLength = false;
//        boolean bBladeWidth = false;
//        boolean bMaterial = false;
//        boolean bHandle = false;
//        boolean bBloodFlow = false;


        if (bHandy) {
            // age element, set Employee age
            String handy=data.toString();
//            System.out.println("Current data:"+handy);
            if(handy.equals("ONE")){
                arm.setHandy(Handy.ONE);
            }
            if(handy.equals("TWO")){
                arm.setHandy(Handy.TWO);
            }
            bHandy = false;
        } else if (bType) {
            String type=data.toString();
            if(type.equals("KNIFE")){
                arm.setType(Type.KNIFE);
            }
            if(type.equals("DAGGER")){
                arm.setType(Type.DAGGER);
            }
            if(type.equals("SWORD")){
                arm.setType(Type.SWORD);
            }
            bType = false;
        } else if (bOrigin) {
            arm.setOrigin(data.toString());
            bOrigin = false;
        } else if (bCollectible) {
            arm.setCollectible(new Boolean(data.toString()));
            bCollectible = false;
        }
        else if (bBladeLength) {
            arm.setBladeLength(Double.parseDouble(data.toString()));
            bBladeLength = false;
        } else if (bBladeWidth) {
            arm.setBladeWidth(Double.parseDouble(data.toString()));
            bBladeWidth = false;
        } else if (bMaterial) {
        arm.setMaterial(data.toString());
            bMaterial = false;
        } else if (bHandle) {
        arm.setHandle(data.toString());
            bHandle = false;
        } else if (bBloodFlow) {
        arm.setCollectible(new Boolean(data.toString()));
            bBloodFlow = false;
        }



        if (qName.equalsIgnoreCase("steelarm")) {
            // add SteelArm object to list
            armList.add(arm);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }
}
