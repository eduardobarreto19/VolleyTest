package com.example.volleytest;

import java.util.ArrayList;
import java.util.Date;

public class AcademicRecommendation {
    private int id_academic_event;
    private String name_event;
    private int capacity_event;
    private String start_time_event;
    private Date end_time_event;
    private String site_event;
    private String speaker_event;
    private String description_event;
    private ArrayList<String> tags_event;

    public AcademicRecommendation() {

    }

    public AcademicRecommendation(int id_academic_event, String name_event, String start_time_event, String site_event, String speaker_event, String description_event) {
        this.id_academic_event = id_academic_event;
        this.name_event = name_event;
        this.start_time_event = start_time_event;
        this.site_event = site_event;
        this.speaker_event = speaker_event;
        this.description_event = description_event;
    }

    public int getId_academic_event() {
        return id_academic_event;
    }

    public void setId_academic_event(int id_academic_event) {
        this.id_academic_event = id_academic_event;
    }

    public String getName_event() {
        return name_event;
    }

    public void setName_event(String name_event) {
        this.name_event = name_event;
    }

    public int getCapacity_event() {
        return capacity_event;
    }

    public void setCapacity_event(int capacity_event) {
        this.capacity_event = capacity_event;
    }

    public String getStart_time_event() {
        return start_time_event;
    }

    public void setStart_time_event(String start_time_event) {
        this.start_time_event = start_time_event;
    }

    public Date getEnd_time_event() {
        return end_time_event;
    }

    public void setEnd_time_event(Date end_time_event) {
        this.end_time_event = end_time_event;
    }

    public String getSite_event() {
        return site_event;
    }

    public void setSite_event(String site_event) {
        this.site_event = site_event;
    }

    public String getSpeaker_event() {
        return speaker_event;
    }

    public void setSpeaker_event(String speaker_event) {
        this.speaker_event = speaker_event;
    }

    public String getDescription_event() {
        return description_event;
    }

    public void setDescription_event(String description_event) {
        this.description_event = description_event;
    }

    public ArrayList<String> getTags_event() {
        return tags_event;
    }

    public void setTags_event(ArrayList<String> tags_event) {
        this.tags_event = tags_event;
    }

    @Override
    public String toString() {
        return "AcademicRecommendation{" +
                "id_academic_event=" + id_academic_event +
                ", name_event='" + name_event + '\'' +
                ", capacity_event=" + capacity_event +
                ", start_time_event=" + start_time_event +
                ", end_time_event=" + end_time_event +
                ", site_event='" + site_event + '\'' +
                ", speaker_event='" + speaker_event + '\'' +
                ", description_event='" + description_event + '\'' +
                ", tags_event=" + tags_event +
                '}';
    }
}
