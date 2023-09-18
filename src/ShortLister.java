import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ShortLister {

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {

            try {
                FileReader fileReader = new FileReader(fileChooser.getSelectedFile());
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                ArrayList<String> shortWords = new ArrayList<>();

                while ((line = bufferedReader.readLine()) != null) {
                    String[] words = line.split("\\s+");
                    for (String word : words) {

                        if (word.length() < 5) {
                            shortWords.add(word);
                        }
                    }
                }

                bufferedReader.close();
                // Display short words
                System.out.println("Short words: " + shortWords);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}