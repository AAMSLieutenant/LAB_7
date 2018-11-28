package Parsers;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.xml.sax.SAXException;
import steelArms.SteelArm;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SAX {

    private static final Logger log= Logger.getLogger(SAX.class);
    static {
        PropertyConfigurator.configure("log4j.properties");
    }

    public static void parse(String fileName){
        log.info("SAX parse started");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXHandler handler = new SAXHandler();
            saxParser.parse(new File(fileName), handler);
            //Get Employees list
            List<SteelArm> armList = handler.getArmList();
            //print employee information
            for(SteelArm arm : armList)
                System.out.println(arm);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }
}
