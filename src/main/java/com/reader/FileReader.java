package com.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public List<String> readFile(String path) {
        List<String> lines = new ArrayList<>();
        String line;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    this.getClass().getResourceAsStream("/" + path), StandardCharsets.UTF_8));

            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (UnsupportedEncodingException e) {
            System.err.println("Error while reading file format");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error while reading file");
            e.printStackTrace();
        } catch (NullPointerException e){
            System.err.println("Error while reading file: file not found");
            e.printStackTrace();
        }

        return lines;
    }
}
