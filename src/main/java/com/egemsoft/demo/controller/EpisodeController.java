package com.egemsoft.demo.controller;

import com.egemsoft.demo.model.character.Character;
import com.egemsoft.demo.model.epsisode.EpisodeRequest;
import com.egemsoft.demo.model.epsisode.EpisodeResponse;
import com.egemsoft.demo.model.epsisode.Episodes;
import com.egemsoft.demo.service.EpisodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/episode")
public class EpisodeController {
    private final EpisodeService episodeService;

    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping
    public EpisodeResponse getEpisodes(EpisodeRequest request) {
        return episodeService.getEpisode(request);
    }

    @GetMapping(value = "/{id}")
    public Episodes getEpisodeById(@PathVariable String id){
        return episodeService.getCharacterById(id);
    }
}
