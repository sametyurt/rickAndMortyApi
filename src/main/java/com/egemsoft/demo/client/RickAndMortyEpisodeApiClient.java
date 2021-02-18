package com.egemsoft.demo.client;

import com.egemsoft.demo.model.epsisode.EpisodeResponse;
import com.egemsoft.demo.model.epsisode.Episodes;
import com.egemsoft.demo.model.location.LocationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/***
 * Bu sınıf bölümlerin özelliklerini urlden çekilmesini sağlar.
 */
@FeignClient(name = "rickAndMortyApi2", url = "${client.url.rick-and-morty-api}")
public interface RickAndMortyEpisodeApiClient {

    @GetMapping("/episode")
    EpisodeResponse getEpisodes(
            @RequestParam("name") String name,
            @RequestParam("episode") String episode,
            @RequestParam(value = "charactersNumber", required = false, defaultValue = "0") int charactersNumber
    );

    @GetMapping("/episode/{id}")
    Episodes getEpisodeById(
            @PathVariable("id") String id
    );
}
