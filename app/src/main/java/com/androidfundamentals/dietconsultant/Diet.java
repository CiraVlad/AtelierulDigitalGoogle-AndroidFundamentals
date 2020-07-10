package com.androidfundamentals.dietconsultant;

public class Diet {

    private String name;
    private String description;
    private String startTime;
    private String endTime;

    public Diet(String name, String description, String startTime, String endTime) {
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}
