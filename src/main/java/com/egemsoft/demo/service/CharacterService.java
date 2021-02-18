package com.egemsoft.demo.service;

import com.egemsoft.demo.client.RickAndMortyCharacterApiClient;
import com.egemsoft.demo.model.character.Character;
import com.egemsoft.demo.model.character.CharacterRequest;
import com.egemsoft.demo.model.character.CharacterResponse;
import com.egemsoft.demo.model.character.Info;
import com.sun.istack.Nullable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {


    private final RickAndMortyCharacterApiClient rickAndMortyCharacterApiClient;

    public CharacterService(RickAndMortyCharacterApiClient rickAndMortyCharacterApiClient) {
        this.rickAndMortyCharacterApiClient = rickAndMortyCharacterApiClient;
    }


    /***
     * Bu metot karakter sayfasına istek atarak verirleri istenilen filtreye göre döndürür.
     * request ChapterPlayed 0dan farklıysa oynanan oyuna göre filtreleme yapar.
     * O(n) karmaşıklığında çalışır.
     * @param request request body
     * @return karakterlerin verilerini döndürür
     */
    public CharacterResponse getCharacters(CharacterRequest request) {
        CharacterResponse result = rickAndMortyCharacterApiClient.getCharacters(request.getPage(), request.getName(),
                request.getStatus(), request.getChapterPlayed());


        if(request.getChapterPlayed() != 0) {
            CharacterResponse returnValue = new CharacterResponse();

            Info info = result.getInfo();
            List<Character> characters = new ArrayList<>();

            for (int i = 0; i < result.getResults().size(); ++i) {
                if (result.getResults().get(i).getEpisode().size() == request.getChapterPlayed()) {
                    characters.add(result.getResults().get(i));
                }
            }
            returnValue.setInfo(info);
            returnValue.setResults(characters);

            return returnValue;
        }

        return rickAndMortyCharacterApiClient.getCharacters(request.getPage(), request.getName(), request.getStatus(),request.getChapterPlayed());

    }

   public Character getCharacterById(String id){
        return rickAndMortyCharacterApiClient.getCharacterById(id);
   }
}