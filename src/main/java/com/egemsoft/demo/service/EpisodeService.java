package com.egemsoft.demo.service;

import com.egemsoft.demo.client.RickAndMortyEpisodeApiClient;
import com.egemsoft.demo.model.character.Character;
import com.egemsoft.demo.model.character.CharacterResponse;
import com.egemsoft.demo.model.epsisode.EpisodeRequest;
import com.egemsoft.demo.model.epsisode.EpisodeResponse;
import com.egemsoft.demo.model.epsisode.Episodes;
import com.egemsoft.demo.model.epsisode.Info;
import com.egemsoft.demo.model.location.LocationRequest;
import com.egemsoft.demo.model.location.LocationResponse;
import com.egemsoft.demo.model.location.Locations;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EpisodeService {

    private final RickAndMortyEpisodeApiClient rickAndMortyEpisodeApiClient;

    public EpisodeService(RickAndMortyEpisodeApiClient rickAndMortyEpisodeApiClient) {
        this.rickAndMortyEpisodeApiClient = rickAndMortyEpisodeApiClient;
    }

    /***
     * Bu metot episode endpointine istek atarak belirlenen filtrelere göre bilgileri döndürür.
     * Karakter sayısı girildiği durumda kaç adet karakter var o sayfada ona göre filtreler.
     * @param episodeRequest request body
     * @return episodeların bilgilerini döndürür
     */
    public EpisodeResponse getEpisode(EpisodeRequest episodeRequest){
        //return rickAndMortyEpisodeApiClient.getEpisodes(episodeRequest.getName(), episodeRequest.getEpisode());

        EpisodeResponse result = rickAndMortyEpisodeApiClient.getEpisodes(episodeRequest.getName(),
                episodeRequest.getEpisode(), episodeRequest.getCharacters());

        if(episodeRequest.getCharacters() != 0){
            EpisodeResponse episodeResponse = new EpisodeResponse();
            Info info = result.getInfo();
            List<Episodes> characters = new ArrayList<>();

            for (int i = 0; i < result.getResults().size(); ++i) {
                if (result.getResults().get(i).getCharacters().size() == episodeRequest.getCharacters()) {
                    characters.add(result.getResults().get(i));
                }
            }
            episodeResponse.setInfo(info);
            episodeResponse.setResults(characters);

            return episodeResponse;
        }

        return result;

    }

    public Episodes getCharacterById(String id) {
        return rickAndMortyEpisodeApiClient.getEpisodeById(id);
    }
}
