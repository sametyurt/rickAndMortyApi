package com.egemsoft.demo.client;

import com.egemsoft.demo.model.character.Character;
import com.egemsoft.demo.model.character.CharacterResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/***
 * FeignClient kullanarak remote olarak verilen urldeki dataların
 * modellenmiş olarak yazılmış sınıflarla maplenmesini yapan sınıftır.
 */
@FeignClient(name = "rickAndMortyApi", url = "${client.url.rick-and-morty-api}")
public interface RickAndMortyCharacterApiClient {

    /***
     *
     * @param page sayfa filtresi
     * @param name karakter ismi filtresi
     * @param status status filtresi
     * @param chapterPlayed kaç bölümde oynandığını tutan parametre
     * @return istek sonucunda karakterlerin verilerini döndürür.
     */
    @GetMapping("/character")
    CharacterResponse getCharacters(
            @RequestParam("page") int page,
            @RequestParam("name") String name,
            @RequestParam("status") String status,
            @RequestParam(value = "chapterPlayed", required = false, defaultValue = "0") int chapterPlayed
    );

    /***
     * Bu metot idsine göre karakter özelliklerini çeker.
     * @param id karakter idsi
     * @return belli bir karakterin bilgileri
     */
    @RequestMapping(method = RequestMethod.GET, value = "/character/{id}", consumes = "application/json")
    Character getCharacterById(
            @PathVariable("id") String id
    );

}