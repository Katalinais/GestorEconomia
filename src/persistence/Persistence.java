package persistence;

import model.Activity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Persistence {
    public static ArrayList<Activity> loadActivitiesXml(String fileName, ArrayList<String> categories) {
        ArrayList<Activity> activities = new ArrayList<>();

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document document = docBuilder.parse(new File(fileName));

            NodeList activityNodes = document.getElementsByTagName("Activity");

            for (int i = 0; i < activityNodes.getLength(); i++) {
                Node activityNode = activityNodes.item(i);

                if (activityNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element activityElement = (Element) activityNode;
                    int amount = Integer.parseInt(activityElement.getElementsByTagName("Amount").item(0).getTextContent());
                    String category = activityElement.getElementsByTagName("Category").item(0).getTextContent();
                    String dateString = activityElement.getElementsByTagName("Date").item(0).getTextContent();
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);

                    Activity activity = new Activity(amount, category, date,categories);
                    activities.add(activity);
                }
            }
        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException | ParseException e) {
            e.printStackTrace();
        }
        return activities;
    }

    public static ArrayList<String> loadCategoriesXml(String fileName) {
        ArrayList<String> categories = new ArrayList<>();

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document document = docBuilder.parse(new File(fileName));

            NodeList categoryNodes = document.getElementsByTagName("Category");

            for (int i = 0; i < categoryNodes.getLength(); i++) {
                Node categoryNode = categoryNodes.item(i);

                if (categoryNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element categoryElement = (Element) categoryNode;
                    String category = categoryElement.getTextContent();
                    categories.add(category);
                }
            }
        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException e) {
            e.printStackTrace();
        }

        return categories;
    }
}
