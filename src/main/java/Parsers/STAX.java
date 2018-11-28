package Parsers;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import steelArms.Handy;
import steelArms.SteelArm;
import steelArms.Type;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class STAX {

    private static List<SteelArm> armList;
    private static final Logger log= Logger.getLogger(STAX.class);
    static {
        PropertyConfigurator.configure("log4j.properties");
    }

    public static void parse(String fileName){
        log.info("STAX Parsing");
        armList = parseXML(fileName);
        System.out.println(armList.size());

    }









    private static List<SteelArm> parseXML(String fileName) {
        List<SteelArm> armList = new ArrayList<>();
        SteelArm arm = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));

            while (xmlEventReader.hasNext()) {

                XMLEvent xmlEvent = xmlEventReader.nextEvent();

                if (xmlEvent.isStartElement()) {

                    StartElement startElement = xmlEvent.asStartElement();

                    if (startElement.getName().getLocalPart().equalsIgnoreCase("SteelArm")) {
                        System.out.println("ELEMENT STARTED");
                        System.out.println(startElement.getName().getLocalPart()+"----------------");
                        arm = new SteelArm();
                        //Get the 'id' attribute from Employee element
//                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
//                        if(idAttr != null){
//                            emp.setId(Integer.parseInt(idAttr.getValue()));
//                        }
                    }
                    //set the other varibles from xml elements
                    else if (startElement.getName().getLocalPart().equalsIgnoreCase("handy")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        String handy = xmlEvent.asCharacters().getData();
                        if (handy.equals("ONE")) {
                            arm.setHandy(Handy.ONE);
                        }
                        if (handy.equals("TWO")) {
                            arm.setHandy(Handy.TWO);
                        }
                        System.out.println("HANDY "+handy);
                    } else if (startElement.getName().getLocalPart().equalsIgnoreCase("type")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        String type = xmlEvent.asCharacters().getData();
                        if (type.equals("DAGGER")) {
                            arm.setType(Type.DAGGER);
                        }
                        if (type.equals("KNIFE")) {
                            arm.setType(Type.KNIFE);
                        }
                        if (type.equals("SWORD")) {
                            arm.setType(Type.SWORD);
                        }
                        System.out.println("TYPE "+type);
                    } else if (startElement.getName().getLocalPart().equalsIgnoreCase("origin")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        String origin = xmlEvent.asCharacters().getData();
                        arm.setOrigin(origin);
                        System.out.println("TYPE "+origin);

                    } else if (startElement.getName().getLocalPart().equalsIgnoreCase("collectible")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        String collectible = xmlEvent.asCharacters().getData();
                        if (collectible.equals("true")) {
                            arm.setCollectible(true);
                        }
                        if (collectible.equals("false")) {
                            arm.setCollectible(false);
                        }
                        System.out.println("COLLECTIBLE "+collectible);
                    } else if (startElement.getName().getLocalPart().equalsIgnoreCase("bladeLength")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        double bladeLength = Double.parseDouble(xmlEvent.asCharacters().getData());
                        arm.setBladeLength(bladeLength);
                        System.out.println("BLADELENGTH "+bladeLength);
                    }
                    else if (startElement.getName().getLocalPart().equalsIgnoreCase("bladeWidth")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        double bladeWidth = Double.parseDouble(xmlEvent.asCharacters().getData());
                        arm.setBladeWidth(bladeWidth);
                        System.out.println("BLADEWIDTH "+bladeWidth);
                    }
                    else if (startElement.getName().getLocalPart().equalsIgnoreCase("material")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        String material = xmlEvent.asCharacters().getData();
                        arm.setMaterial(material);
                        System.out.println("MATERIAL "+material);
                    }
                    else if (startElement.getName().getLocalPart().equalsIgnoreCase("handle")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        String handle = xmlEvent.asCharacters().getData();
                        arm.setHandle(handle);
                        System.out.println("HANDLE "+handle);
                    }
                    else if (startElement.getName().getLocalPart().equalsIgnoreCase("bloodFlow")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        String bloodFlow = xmlEvent.asCharacters().getData();
                        if (bloodFlow.equals("true")) {
                            arm.setBloodFlow(true);
                        }
                        if (bloodFlow.equals("false")) {
                            arm.setBloodFlow(false);
                        }
                        System.out.println("BLOODFLOW "+bloodFlow);
                    }
                    //if Employee end element is reached, add employee object to list

                }
                if (xmlEvent.isEndElement()){


                    EndElement endElement = xmlEvent.asEndElement();


                    if (endElement.getName().getLocalPart().equalsIgnoreCase("steelarm")) {
                        System.out.println("END ELEMENT----------------");
                        System.out.println("ENDING fffffffffffffffffffffELEMENT ");
                        System.out.println("ARM "+arm);
                        armList.add(arm);
                    }
                }
            }
        }
        catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
//        for(SteelArm emp : armList){
//            System.out.println(emp);
//        }
        return armList;
    }
}
