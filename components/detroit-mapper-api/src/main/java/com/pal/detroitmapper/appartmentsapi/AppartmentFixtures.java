package com.pal.detroitmapper.appartmentsapi;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.pal.detroitmapper.CSVUtils.readFromCsv;

@Component
public class AppartmentFixtures {

    private final ObjectReader objectReader;

    public AppartmentFixtures() {
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
        objectReader = new CsvMapper().readerFor(AppartmentInfo.class).with(schema);
    }

    public List<AppartmentInfo> load() {
        return readFromCsv(objectReader, "restro.csv");
    }
}
