package com.pal.detroitmapper.restaurantsapi;

import java.util.List;

import static java.util.Arrays.asList;

public class RestaurantFixtures {

    public List<RestaurantInfo> load() {
        return asList(
                new RestaurantInfo("Bay Leaf", "35203 Grand River Ave", "Detroit", "Michigan", "48335", "(248) 987-6824",null,"Indian","$15 per person" )
        );
    }
}
