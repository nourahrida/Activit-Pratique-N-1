package org.miniproject.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;

public class XmlConfigParser {

    public void parseXmlFile(String filePath) {
        try {
            // Create a new factory to create DocumentBuilder instances
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filePath));
            document.getDocumentElement().normalize();
            NodeList beanList = document.getElementsByTagName("bean");

            for (int temp = 0; temp < beanList.getLength(); temp++) {
                Node node = beanList.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String id = element.getAttribute("id");
                    String className = element.getAttribute("class");

                    System.out.println("Bean ID : " + id);
                    System.out.println("Class Name : " + className);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
