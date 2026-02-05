package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Reads a flat file from resources as a stream of lines.
 */
public class FileInputProcessor {

    private final String fileName;

    public FileInputProcessor(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Reads all lines from the txt files in resources folder.
     */
    public Stream<String> readLines() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IOException("File not found in resources: " + fileName);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return reader.lines();
    }
}
