package persistence;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.Activity;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Persistence {

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

    public static void addActivity(Activity newActivity, String nameFile) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();

            JsonNode rootNode = objectMapper.readTree(new File(nameFile));
            JsonNode activitiesNode = rootNode.path("registerActivities").path("activities");

            com.fasterxml.jackson.databind.node.ObjectNode newActivityNode = objectMapper.createObjectNode();
            newActivityNode.put("amount", newActivity.getAmount());
            newActivityNode.put("category", newActivity.getCategory());
            newActivityNode.put("date", newActivity.getDate().toString());

            ((com.fasterxml.jackson.databind.node.ArrayNode) activitiesNode).add(newActivityNode);

            objectWriter.writeValue(new File(nameFile), rootNode);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addCategory(String newCategory, String nameFile) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();

            JsonNode rootNode = objectMapper.readTree(new File(nameFile));
            JsonNode categoriesNode = rootNode.path("registerActivities").path("categories");

            com.fasterxml.jackson.databind.node.ObjectNode newCategoryNode = objectMapper.createObjectNode();
            newCategoryNode.put("category", newCategory);


            ((com.fasterxml.jackson.databind.node.ArrayNode) categoriesNode).add(newCategoryNode);

            objectWriter.writeValue(new File(nameFile), rootNode);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
