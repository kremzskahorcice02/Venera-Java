package com.example.venera.models;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String url;
    private String city;
    private String place;

    private String otherArtists;
    public Event() {
    }

    public Event(String title, String date, String city, String place, String otherArtists, String url) {
        this.title = title;
        this.date = this.formatStringToDate(date);
        this.city = city;
        this.place = place;
        this.otherArtists = otherArtists;
        this.url = url;
    }

    public Date formatStringToDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOtherArtists() {
        return otherArtists;
    }

    public void setOtherArtists(String otherArtists) {
        this.otherArtists = otherArtists;
    }
}
