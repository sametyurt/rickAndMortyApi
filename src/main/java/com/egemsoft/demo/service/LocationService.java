package com.egemsoft.demo.service;

import com.egemsoft.demo.client.RickAndMortyLocationApiClient;
import com.egemsoft.demo.model.location.LocationRequest;
import com.egemsoft.demo.model.location.LocationResponse;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private final RickAndMortyLocationApiClient rickAndMortyLocationApiClient;

    public LocationService(RickAndMortyLocationApiClient rickAndMortyLocationApiClient) {
        this.rickAndMortyLocationApiClient = rickAndMortyLocationApiClient;
    }

    public LocationResponse getLocations(LocationRequest locationRequest){
        return rickAndMortyLocationApiClient.getLocations(locationRequest.getName(), locationRequest.getType(), locationRequest.getDimension());
    }


}
