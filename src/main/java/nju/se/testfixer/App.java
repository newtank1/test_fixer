package nju.se.testfixer;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException {
//        InputStream inputStream1= Files.newInputStream(Paths.get("test1.html"));
//        Document document1 = new XMLReader().readXML(inputStream1);
//        InputStream inputStream2= Files.newInputStream(Paths.get("test2.html"));
//        Document document2 = new XMLReader().readXML(inputStream2);
//
//        NodeComparator xmlComparator = new NodeComparator();
//        Map<Node, Node> nodeNodeMap = xmlComparator.matchElements(document1, document2, 5);
//        int i=0;
//        for (Map.Entry<Node, Node> entry : nodeNodeMap.entrySet()) {
//            ((Element)entry.getKey()).setAttribute("pair",String.valueOf(i));
//            ((Element)entry.getValue()).setAttribute("pair",String.valueOf(i));
//            i++;
//        }
//        System.out.println(nodeNodeMap);
//
//        TransformerFactory transformerFactory = TransformerFactory.newInstance();
//        Transformer transformer = transformerFactory.newTransformer();
//        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
//        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","4");
//        DOMSource source1 = new DOMSource(document1);
//        FileWriter writer1=new FileWriter("test1res.xml");
//        StreamResult result1 = new StreamResult(writer1);
//        transformer.transform(source1, result1);
//
//        DOMSource source2 = new DOMSource(document2);
//        FileWriter writer2=new FileWriter("test2res.xml");
//        StreamResult result2 = new StreamResult(writer2);
//        transformer.transform(source2, result2);
    }
}
