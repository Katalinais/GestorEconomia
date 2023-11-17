package persistence;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Persistence {
    /*
    public static ArrayList<Activity> loadActivitiesXml(String fileName) {
        ArrayList<Activity> activities = new ArrayList<>();

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document document = docBuilder.parse(new File(fileName));

            NodeList activityNodes = document.getElementsByTagName("activity");

            for (int i = 0; i < activityNodes.getLength(); i++) {
                Node activityNode = activityNodes.item(i);

                if (activityNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element activityElement = (Element) activityNode;
                    int amount = Integer.parseInt(activityElement.getElementsByTagName("amount").item(0).getTextContent());
                    String category = activityElement.getElementsByTagName("category").item(0).getTextContent();
                    String dateString = activityElement.getElementsByTagName("date").item(0).getTextContent();
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);

                    Activity activity = new Activity(amount, category, date);
                    activities.add(activity);
                }
            }
        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException | ParseException e) {
            e.printStackTrace();
        }
        return activities;
    }

     */

    public static ArrayList<String> loadCategoriesXml(String fileName) {
        ArrayList<String> categories = new ArrayList<>();

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document document = docBuilder.parse(new File(fileName));

            NodeList categoryNodes = document.getElementsByTagName("category");

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

    public static ArrayList<Activity> readActivities(String fileName){
        ArrayList<Activity> activities = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(fileName));
            JsonNode activitiesNode = rootNode.path("registerActivities").path("activities");

            for (JsonNode activityNode : activitiesNode) {
                int amount = Integer.parseInt(activityNode.get("amount").asText());
                String category = activityNode.get("category").asText();
                String dateStr = activityNode.get("date").asText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(dateStr, formatter);
                Activity activity = new Activity(amount, category, date);
                activities.add(activity);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return activities;
    }

    public static ArrayList<String> readCategories(String fileName){
        ArrayList<String> categories = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(fileName));
            JsonNode activitiesNode = rootNode.path("registerActivities").path("categories");

            for (JsonNode activityNode : activitiesNode) {
                String category = activityNode.get("category").asText();
                categories.add(category);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
