package com.pal.detroitmapper;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVUtils {

    public static String readFile(String path) {
        ClassLoader loader = CSVUtils.class.getClassLoader();
        InputStream inputStream = loader.getResourceAsStream(path);

        Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");

        if (scanner.hasNext()) {
            return scanner.next();
        }
        return "";
    }

    public static <T>List<T> readFromCsv(ObjectReader reader, String path) {
        try {
            List<T> results = new ArrayList<>();

            MappingIterator<T> iterator = reader.readValues(readFile(path));
            while (iterator.hasNext()) {
                results.add(iterator.nextValue());
            }

            return results;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
