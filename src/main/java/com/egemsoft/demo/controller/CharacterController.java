package com.egemsoft.demo.controller;

import com.egemsoft.demo.model.character.Character;
import com.egemsoft.demo.model.character.CharacterRequest;
import com.egemsoft.demo.model.character.CharacterResponse;
import com.egemsoft.demo.service.CharacterService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/character")
public class CharacterController {

    private final CharacterService characterService;


    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public CharacterResponse getCharacters(CharacterRequest request) {
        return characterService.getCharacters(request);
    }

    @GetMapping(value = "/{id}")
    public Character getCharacterById(@PathVariable String id){
        return characterService.getCharacterById(id);
    }
}