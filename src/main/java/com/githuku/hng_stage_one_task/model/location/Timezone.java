package com.githuku.hng_stage_one_task.model.location;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Timezone {
    private String name;
    private String abbreviation;
    @JsonProperty("gmt_offset")
    private int gmtOffset;
    @JsonProperty("current_time")
    private String currentTime;
    @JsonProperty("is_dst")
    private boolean isDst;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getGmtOffset() {
        return gmtOffset;
    }

    public void setGmtOffset(int gmtOffset) {
        this.gmtOffset = gmtOffset;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public boolean isDst() {
        return isDst;
    }

    public void setDst(boolean dst) {
        isDst = dst;
    }
}

