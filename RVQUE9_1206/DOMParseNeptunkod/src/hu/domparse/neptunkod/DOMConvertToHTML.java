package hu.domparse.neptunkod;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DOMConvertToHTML {
    public static void main(String[] args) {
        try {
            // Load the XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document document = builder.parse(new File("hallgatoRVQUE9.xml"));

            // Load the XSLT stylesheet
            StreamSource stylesource = new StreamSource(new File("hallgatoRVQUE9.xsl"));

            // Create a transformer
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer(stylesource);

            // Transform the XML to HTML
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("hallgatoRVQUE9.html"));
            transformer.transform(source, result);

            System.out.println("XML file converted to HTML successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
