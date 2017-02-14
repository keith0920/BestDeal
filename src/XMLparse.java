





import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import entity.Console;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;




public class XMLparse extends DefaultHandler {
    Console console;
    List<Console> consoles;
    String consoleXmlFileName;
    String elementValueRead;


    public XMLparse(String consoleXmlFileName) {
        this.consoleXmlFileName = consoleXmlFileName;
        consoles = new ArrayList<Console>();
        parseDocument();
        //prettyPrint();
    }


    private void parseDocument() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(consoleXmlFileName, this);
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfig error");
        } catch (SAXException e) {
            System.out.println("SAXException : xml not well formed");
        } catch (IOException e) {
            System.out.println("IO error");
        }
    }


    private void prettyPrint() {

        for (Console console: consoles) {
            System.out.println("console #"+ console.id +":");
            System.out.println("\t\t retailer: " + console.retailer);
            System.out.println("\t\t name: " + console.name);
            System.out.println("\t\t price: " + console.price);
            System.out.println("\t\t condition: " + console.condition);
            //System.out.println("\t\t discount: " + console.discount);
            System.out.println("\t\t category: " + console.category);

        }
    }







    @Override
    public void startElement(String str1, String str2, String elementName, Attributes attributes) throws SAXException {

        if (elementName.equalsIgnoreCase("console")) {
            console = new Console();
            console.setId(attributes.getValue("id"));
            console.setRetailer(attributes.getValue("retailer"));
        }

    }

    @Override
    public void endElement(String str1, String str2, String element) throws SAXException {

        if (element.equals("console")) {
            consoles.add(console);
            return;
        }
        if (element.equalsIgnoreCase("name")) {
            console.setName(elementValueRead);
            return;
        }
        if(element.equalsIgnoreCase("price")){
            console.setPrice(Integer.parseInt(elementValueRead));
            return;
        }
        if (element.equalsIgnoreCase("retailer")) {
            console.setRetailer(elementValueRead);
            return;
        }
        if (element.equalsIgnoreCase("condition")) {
            console.setCondition(elementValueRead);
            return;
        }
//        if (element.equalsIgnoreCase("discount")) {
//            console.setDiscount(elementValueRead);
//            return;
//        }
        if (element.equalsIgnoreCase("category")) {
            console.setCategory(elementValueRead);
            return;
        }

    }

    @Override
    public void characters(char[] content, int begin, int end) throws SAXException {
        elementValueRead = new String(content, begin, end);
    }


   
    public static void main(String[] args) {
        new XMLparse("ProductCatalog.xml");

    }

}
