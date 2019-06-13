package com.pal.detroitmapper.apartmentsapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class ApartmentClient {
    private String apartmentsUrl;
    private RestOperations restOperations;

    private static ParameterizedTypeReference<List<ApartmentInfo>> apartmentListType = new ParameterizedTypeReference<List<ApartmentInfo>>() {
    };

    public ApartmentClient(String apartmentsUrl, RestOperations restOperations) {
        this.apartmentsUrl = apartmentsUrl;
        this.restOperations = restOperations;
    }

    public ApartmentInfo find(long id) {
        return restOperations.getForEntity(apartmentsUrl + "/" + id, ApartmentInfo.class).getBody();
    }

    public void addApartment(ApartmentInfo apartment) {
        restOperations.postForEntity(apartmentsUrl, apartment, ApartmentInfo.class);
    }

    public void deleteApartmentId(Long apartmentId) {
        restOperations.delete(apartmentsUrl + "/" + apartmentId);
    }

    public int countAll() {
        return restOperations.getForObject(apartmentsUrl + "/count", Integer.class);
    }

    public int count(String field, String key) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apartmentsUrl + "/count")
                .queryParam("field", field)
                .queryParam("key", key);

        return restOperations.getForObject(builder.toUriString(), Integer.class);
    }

    public List<ApartmentInfo> findAll(int start, int pageSize) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apartmentsUrl)
                .queryParam("start", start)
                .queryParam("pageSize", pageSize);

        return restOperations.exchange(builder.toUriString(), GET, null, apartmentListType).getBody();
    }

    public List<ApartmentInfo> findRange(String field, String key, int start, int pageSize) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apartmentsUrl)
                .queryParam("field", field)
                .queryParam("key", key)
                .queryParam("start", start)
                .queryParam("pageSize", pageSize);

        return restOperations.exchange(builder.toUriString(), GET, null, apartmentListType).getBody();
    }

    public List<ApartmentInfo> getMovies() {
        return restOperations.exchange(apartmentsUrl, GET, null, apartmentListType).getBody();
    }
}
