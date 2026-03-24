import java.io.*;

class FileHandler {

    public static void log(String data) {
        try (FileWriter fw = new FileWriter("log.txt", true)) {
            fw.write(data + "\n");
        } catch (IOException e) {
            System.out.println("Error writing log");
        }
    }
}