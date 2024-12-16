package hu.domparse.neptunkod;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DOMConvertRVQUE9 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parse the XML file and build the Document
            Document document = builder.parse(new File("hallgatoRVQUE9.xml"));
            // Normalize the XML structure
            document.getDocumentElement().normalize();
            // Write the document content to a new file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("hallgatoRVQUE9.out.xml"));
            transformer.transform(source, result);
            System.out.println("XML file converted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
