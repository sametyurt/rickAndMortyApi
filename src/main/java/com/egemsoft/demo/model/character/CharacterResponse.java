package com.egemsoft.demo.model.character;

import java.util.ArrayList;
import java.util.List;

public class CharacterResponse {

    private Info info;

    private List<Character> results = new ArrayList<>();

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }
}