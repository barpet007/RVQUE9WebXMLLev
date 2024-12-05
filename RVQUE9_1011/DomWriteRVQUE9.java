
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DomWriteRVQUE9 {
    public static void main(String[] args) {
        try {
            // XML dokumentum beolvasása
            File inputFile = new File("D:\\Repos\\Cloud\\RVQUE9WebXMLLev\\RVQUE9_1011\\RVQUE9__orarend.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);

            // Normálizálás
            doc.getDocumentElement().normalize();

            // Fastruktúra kiírása konzolra
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            printNode(doc.getDocumentElement(), 0);

            // XML mentése új fájlba
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("orarend1RVQUE9.xml"));
            transformer.transform(source, result);

            System.out.println("\nAz új fájl sikeresen létrehozva: orarend1RVQUE9.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Rekurzív metódus a DOM fa kiírásához
    private static void printNode(Node node, int depth) {
        String indent = "  ".repeat(depth);

        // Elem információ kiírása
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            System.out.println(indent + "<" + element.getNodeName() + ">");
            
            // Attribútumok kiírása
            NamedNodeMap attributes = element.getAttributes();
            for (int i = 0; i < attributes.getLength(); i++) {
                Node attr = attributes.item(i);
                System.out.println(indent + "  @" + attr.getNodeName() + " = " + attr.getNodeValue());
            }

            // Gyerekek kiírása
            NodeList children = element.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                printNode(children.item(i), depth + 1);
            }

            System.out.println(indent + "</" + element.getNodeName() + ">");
        } else if (node.getNodeType() == Node.TEXT_NODE) {
            String textContent = node.getTextContent().trim();
            if (!textContent.isEmpty()) {
                System.out.println(indent + textContent);
            }
        }
    }
}