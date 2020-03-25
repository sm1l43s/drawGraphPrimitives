package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFromFile {

    public ArrayList getGraphPrimitives() {
        ArrayList graphPrimitives = new ArrayList();
        try (FileReader fileReader = new FileReader("file.txt")) {
            BufferedReader reader = new BufferedReader(fileReader);

            // reade first line
            String line = reader.readLine();
            while (line != null) {
                graphPrimitives.add(line);
                // read another line
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return graphPrimitives;
    }
}
