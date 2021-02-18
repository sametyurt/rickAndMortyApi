package com.egemsoft.demo.model.character;

public class CharacterRequest {

    private int page = 0;
    private String name;
    private String status;
    private int chapterPlayed;


    public int getChapterPlayed() {
        return chapterPlayed;
    }

    public void setChapterPlayed(int chapterPlayed) {
        this.chapterPlayed = chapterPlayed;
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}