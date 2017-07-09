package Tools;

import Core.BugInstance;
import Core.Field;
import Data.AlertContract;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YUNUS on 16.04.2017.
 */
public class FindBugs extends ToolBase {
    public FindBugs(String inputPath) {
        super(inputPath);
    }

    @Override
    protected List<BugInstance> ParseAlerts() {
        List<BugInstance> alerts = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            File file = new File(getInputPath());
            Document document = builder.parse(file);
            NodeList nodeList = document.getElementsByTagName("BugInstance");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    BugInstance bugInstance = new BugInstance();
                    bugInstance.setAlertType(element.getAttributes().getNamedItem("type").getNodeValue());
                    NodeList fieldList = element.getElementsByTagName("Field");
                    for (int j = 0; j < fieldList.getLength(); j++) {
                        Node fieldNode = fieldList.item(j);
                        if (fieldNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element fieldElement = (Element) fieldNode;
                            Field field = new Field();
                            field.setSignature( StringUtils.substringBeforeLast(StringUtils.substringAfterLast(fieldElement.getAttributes().getNamedItem("signature").getNodeValue(), "/"), ";"));
                            field.setClassName(fieldElement.getAttributes().getNamedItem("classname").getNodeValue());
                            field.setName(fieldElement.getAttributes().getNamedItem("name").getNodeValue());
                            bugInstance.addMember(field);
                        }
                    }
                    //TODO:::METHOD
                    alerts.add(bugInstance);
                }
            }
        }
        catch (Exception ex){}
        return alerts;
    }
}
