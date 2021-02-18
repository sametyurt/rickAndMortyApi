package com.egemsoft.demo.model.epsisode;

import com.egemsoft.demo.model.location.Locations;

import java.util.ArrayList;
import java.util.List;

public class EpisodeResponse {

    private Info info;

    private List<Episodes> results = new ArrayList<>();

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Episodes> getResults() {
        return results;
    }

    public void setResults(List<Episodes> results) {
        this.results = results;
    }
}
