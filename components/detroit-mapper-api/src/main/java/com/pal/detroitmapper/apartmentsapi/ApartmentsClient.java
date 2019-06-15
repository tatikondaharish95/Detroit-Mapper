package com.pal.detroitmapper.apartmentsapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class ApartmentsClient {

    private String apartmentsUrl;
    private RestOperations restOperations;

    private static ParameterizedTypeReference<List<ApartmentInfo>> apartmentInfoType = new ParameterizedTypeReference<List<ApartmentInfo>>() {
    };

    public ApartmentsClient(String apartmentsUrl, RestOperations restOperations) {
        this.apartmentsUrl = apartmentsUrl;
        this.restOperations = restOperations;
    }

    public void addApartment(ApartmentInfo apartmentInfo) {
        restOperations.postForEntity(apartmentsUrl, apartmentInfo, ApartmentInfo.class);
    }

    public void deleteApartmentId(Long apartmentId) {
        restOperations.delete(apartmentsUrl + "/" + apartmentId);
    }


    public ApartmentInfo find(long id) {
        return restOperations.getForEntity(apartmentsUrl + "/" + id, ApartmentInfo.class).getBody();
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

        return restOperations.exchange(builder.toUriString(), GET, null, apartmentInfoType).getBody();
    }

    public List<ApartmentInfo> findRange(String field, String key, int start, int pageSize) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apartmentsUrl)
                .queryParam("field", field)
                .queryParam("key", key)
                .queryParam("start", start)
                .queryParam("pageSize", pageSize);

        return restOperations.exchange(builder.toUriString(), GET, null, apartmentInfoType).getBody();
    }

    public List<ApartmentInfo> getApartments() {
        ParameterizedTypeReference<List<ApartmentInfo>> apartmentInfoListReference = new ParameterizedTypeReference<List<ApartmentInfo>>() {
        };

        return restOperations.exchange(apartmentsUrl, GET, null, apartmentInfoListReference).getBody();
    }
}
