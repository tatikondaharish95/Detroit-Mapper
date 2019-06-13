package com.pal.detroitmapper.restaurantsapi;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.pal.detroitmapper.CSVUtils.readFromCsv;
import static java.util.Arrays.asList;

@Component
public class RestaurantFixtures {

    private final ObjectReader objectReader;

    public RestaurantFixtures() {
        CsvSchema schema = CsvSchema.builder()
                .addColumn("name")
                .addColumn("street_address")
                .addColumn("city")
                .addColumn("state")
                .addColumn("pincode")
                .addColumn("phone")
                .addColumn("email")
                .addColumn("cuisine")
                .addColumn("price_range")
                .build();
        objectReader = new CsvMapper().readerFor(RestaurantInfo.class).with(schema);
    }

    public List<RestaurantInfo> load() {
        return readFromCsv(objectReader, "restro.csv");
    }
}
