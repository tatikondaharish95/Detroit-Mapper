package com.pal.detroitmapper.appartmentsapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class ApartmentsClient {

    private String appartmentUrl;
    private RestOperations restOperations;
    private static ParameterizedTypeReference<List<ApartmentInfo>> appartmentListType = new ParameterizedTypeReference<List<ApartmentInfo>>() {
    };
    public ApartmentsClient(String appartmentUrl, RestOperations restOperations) {
        this.appartmentUrl = appartmentUrl;
        this.restOperations = restOperations;
    }
    public void addApartment(ApartmentInfo appartment) {
        restOperations.postForEntity(appartmentUrl, appartment, ApartmentInfo.class);
    }

    public ApartmentInfo find(long id) {
        return restOperations.getForEntity(appartmentUrl + "/" + id, ApartmentInfo.class).getBody();
    }

    public List<ApartmentInfo> getAppartments() {
        ParameterizedTypeReference<List<ApartmentInfo>> appartmentListType = new ParameterizedTypeReference<List<ApartmentInfo>>() {
        };

        return restOperations.exchange(appartmentUrl, GET, null, appartmentListType).getBody();
    }

    public void deleteAppartmentId(Long appartmentId) {
        restOperations.delete(appartmentUrl + "/" + appartmentId);
    }


    public int countAll() {
        return restOperations.getForObject(appartmentUrl + "/count", Integer.class);
    }

    public int count(String field, String key) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(appartmentUrl + "/count")
                .queryParam("field", field)
                .queryParam("key", key);

        return restOperations.getForObject(builder.toUriString(), Integer.class);
    }
    public List<ApartmentInfo> findAll(int start, int pageSize) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(appartmentUrl)
                .queryParam("start", start)
                .queryParam("pageSize", pageSize);

        return restOperations.exchange(builder.toUriString(), GET, null, appartmentListType).getBody();
    }

    public List<ApartmentInfo> findRange(String field, String key, int start, int pageSize) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(appartmentUrl)
                .queryParam("field", field)
                .queryParam("key", key)
                .queryParam("start", start)
                .queryParam("pageSize", pageSize);

        return restOperations.exchange(builder.toUriString(), GET, null, appartmentListType).getBody();
    }

}
