package com.pal.detroitmapper.apartmentsapi;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.pal.detroitmapper.CSVUtils.readFromCsv;

@Component
public class ApartmentFixtures {

    private final ObjectReader objectReader;

    public ApartmentFixtures() {
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
        objectReader = new CsvMapper().readerFor(ApartmentInfo.class).with(schema);
    }

    public List<ApartmentInfo> load() {
        return readFromCsv(objectReader, "restro.csv");
    }
}
