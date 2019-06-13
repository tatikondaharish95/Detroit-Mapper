package com.pal.detroitmapper.apartmentsapi;

import java.util.List;

import static java.util.Arrays.asList;

public class ApartmentFixtures {

    public List<ApartmentInfo> load() {
        return asList(new ApartmentInfo("Legros LLC",1649.35f, "68 Nobel Place",
                "Grand Rapids","Michigan",49560,"6164942558",
                "achasson0@apple.com",true, false,false, false));
    }
}
