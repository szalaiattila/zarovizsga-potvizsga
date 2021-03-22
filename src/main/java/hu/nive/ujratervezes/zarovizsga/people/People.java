package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class People {
    public int getNumberOfMales(String s) {

        try (BufferedReader reader = Files.newBufferedReader(Path.of(s))){
            return parser(reader);

        } catch (IOException e) {
            throw new IllegalStateException("Fájl nem olvasható");
        }
    }

    private int parser(BufferedReader reader) throws IOException {
        String line = "";
        reader.readLine();
        int counter = 0;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if ("Male".equals(parts[4])) {
                counter++;
            }
        }
        return counter;
    }
}

