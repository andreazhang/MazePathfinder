package com.reader;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FileReaderTest {

    @Test
    public void testReadFile_ReturnFileAsListOfString_GivenTextFile(){
        FileReader fileReader = new FileReader();

        List<String> file = fileReader.readFile("input.txt");

        assertNotNull(file);
    }

    @Test
    public void testReadFile_CatchException_GivenInvalidFile(){
        FileReader fileReader = new FileReader();

        fileReader.readFile("fileNotFound.txt");
    }
}