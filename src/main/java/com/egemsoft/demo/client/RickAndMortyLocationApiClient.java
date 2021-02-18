package com.egemsoft.demo.client;

import com.egemsoft.demo.model.character.CharacterResponse;
import com.egemsoft.demo.model.location.LocationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/***
 * Location urline istek atarak bu bilgileri çeker.
 */
@FeignClient(name = "rickAndMortyApi1", url = "${client.url.rick-and-morty-api}")
public interface RickAndMortyLocationApiClient {

    @GetMapping("/location")
    LocationResponse getLocations(
            @RequestParam("name") String name,
            @RequestParam("type") String type,
            @RequestParam("dimension") String dimension
    );
}
