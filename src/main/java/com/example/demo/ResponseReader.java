package com.example.demo;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ResponseReader {

    public List<String[]> GetResponses() throws IOException {
        CSVReader reader = new CSVReaderBuilder(new FileReader(DemoApplication.class.getResource("Responses.csv").getFile())).build();
        return reader.readAll();
    }
}
