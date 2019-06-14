package com.pal.detroitmapper.appartmentsapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class AppartmentsClient {

    private String appartmentUrl;
    private RestOperations restOperations;
    private static ParameterizedTypeReference<List<AppartmentInfo>> appartmentListType = new ParameterizedTypeReference<List<AppartmentInfo>>() {
    };
    public AppartmentsClient(String appartmentUrl, RestOperations restOperations) {
        this.appartmentUrl = appartmentUrl;
        this.restOperations = restOperations;
    }
    public void addApartment(AppartmentInfo appartment) {
        restOperations.postForEntity(appartmentUrl, appartment, AppartmentInfo.class);
    }

    public AppartmentInfo find(long id) {
        return restOperations.getForEntity(appartmentUrl + "/" + id, AppartmentInfo.class).getBody();
    }

    public List<AppartmentInfo> getAppartments() {
        ParameterizedTypeReference<List<AppartmentInfo>> appartmentListType = new ParameterizedTypeReference<List<AppartmentInfo>>() {
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
    public List<AppartmentInfo> findAll(int start, int pageSize) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(appartmentUrl)
                .queryParam("start", start)
                .queryParam("pageSize", pageSize);

        return restOperations.exchange(builder.toUriString(), GET, null, appartmentListType).getBody();
    }

    public List<AppartmentInfo> findRange(String field, String key, int start, int pageSize) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(appartmentUrl)
                .queryParam("field", field)
                .queryParam("key", key)
                .queryParam("start", start)
                .queryParam("pageSize", pageSize);

        return restOperations.exchange(builder.toUriString(), GET, null, appartmentListType).getBody();
    }

}
