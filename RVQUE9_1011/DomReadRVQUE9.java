package domneptunkod1108;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DomReadRVQUE9 {

    public static void main(String[] args) {
        try {
            // XML fájl betöltése
            File xmlFile = new File("RVQUE9_orarend.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Normálizálja az XML struktúrát
            doc.getDocumentElement().normalize();

            // Root elem kiírása
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            // "ora" elemek listájának beolvasása
            NodeList nList = doc.getElementsByTagName("ora");

            System.out.println("\nÓrák listája:");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;

                    // "id" attribútum kiolvasása
                    String id = elem.getAttribute("id");

                    // Elemen belüli adatok kiolvasása
                    String tipus = elem.getAttribute("tipus");
                    String kurzusnev = elem.getElementsByTagName("kurzusnev").item(0).getTextContent();
                    String nap = elem.getElementsByTagName("nap").item(0).getTextContent();
                    String tol = elem.getElementsByTagName("tol").item(0).getTextContent();
                    String ig = elem.getElementsByTagName("ig").item(0).getTextContent();
                    String helyszin = elem.getElementsByTagName("helyszin").item(0).getTextContent();
                    String oktato = elem.getElementsByTagName("oktato").item(0).getTextContent();
                    String szak = elem.getElementsByTagName("szak").item(0).getTextContent();

                    // Blokkos formában kiírás
                    System.out.println("--------------");
                    System.out.println("ID: " + id);
                    System.out.println("Típus: " + tipus);
                    System.out.println("Kurzusnév: " + kurzusnev);
                    System.out.println("Dátum: " + nap);
                    System.out.println("Idő: " + tol + " - " + ig);
                    System.out.println("Helyszín: " + helyszin);
                    System.out.println("Oktató: " + oktato);
                    System.out.println("Szak: " + szak);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
