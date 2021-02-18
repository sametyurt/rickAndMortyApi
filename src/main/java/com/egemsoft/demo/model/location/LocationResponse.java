package com.egemsoft.demo.model.location;

import java.util.ArrayList;
import java.util.List;

public class LocationResponse {

    private Info info;

    private List<Locations> results = new ArrayList<>();

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Locations> getResults() {
        return results;
    }

    public void setResults(List<Locations> results) {
        this.results = results;
    }
}
