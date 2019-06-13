package com.pal.detroitmapper.restaurantsapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class RestaurantsClient {

    private String restaurantsUrl;
    private RestOperations restOperations;

    private static ParameterizedTypeReference<List<RestaurantInfo>> restaurantListType = new ParameterizedTypeReference<List<RestaurantInfo>>() {
    };

    public RestaurantsClient(String restaurantsUrl, RestOperations restOperations) {
        this.restaurantsUrl = restaurantsUrl;
        this.restOperations = restOperations;
    }

    public void addRestaurant(RestaurantInfo restaurantInfo) {
        restOperations.postForEntity(restaurantsUrl, restaurantInfo, RestaurantInfo.class);
    }

    public void deleteRestaurantId(Long restaurantId) {
        restOperations.delete(restaurantsUrl + "/" + restaurantId);
    }


    public RestaurantInfo find(long id) {
        return restOperations.getForEntity(restaurantsUrl + "/" + id, RestaurantInfo.class).getBody();
    }

    public int countAll() {
        return restOperations.getForObject(restaurantsUrl + "/count", Integer.class);
    }

    public int count(String field, String key) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(restaurantsUrl + "/count")
                .queryParam("field", field)
                .queryParam("key", key);

        return restOperations.getForObject(builder.toUriString(), Integer.class);
    }

    public List<RestaurantInfo> findAll(int start, int pageSize) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(restaurantsUrl)
                .queryParam("start", start)
                .queryParam("pageSize", pageSize);

        return restOperations.exchange(builder.toUriString(), GET, null, restaurantListType).getBody();
    }

    public List<RestaurantInfo> findRange(String field, String key, int start, int pageSize) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(restaurantsUrl)
                .queryParam("field", field)
                .queryParam("key", key)
                .queryParam("start", start)
                .queryParam("pageSize", pageSize);

        return restOperations.exchange(builder.toUriString(), GET, null, restaurantListType).getBody();
    }

    public List<RestaurantInfo> getAlbums() {
        ParameterizedTypeReference<List<RestaurantInfo>> restaurantListType = new ParameterizedTypeReference<List<RestaurantInfo>>() {
        };

        return restOperations.exchange(restaurantsUrl, GET, null, restaurantListType).getBody();
    }
}
