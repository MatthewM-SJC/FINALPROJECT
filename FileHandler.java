import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    public static void saveList(ArrayList<String> list, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String item : list) {
                writer.write(item);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving to " + filename);
        }
    }

    public static ArrayList<String> loadList(String filename) {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            System.out.println("Starting with empty list. Couldn't load " + filename);
        }
        return list;
    }
}