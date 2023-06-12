package com.example.venera.models.dtos;

import com.example.venera.models.Event;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventDto {

  private String title;

  private String date;

  private String url;

  private String city;

  private String place;

  private String otherArtists;

  public EventDto(Event event) {
    this.title = event.getTitle();
    this.date = dateToString(event.getDate());
    this.url = event.getUrl();
    this.city = event.getCity();
    this.otherArtists = event.getOtherArtists();
  }

  public String dateToString(Date date) {
    DateFormat dateFormat = new SimpleDateFormat("d.M.yyyy");
    return dateFormat.format(date);
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
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

  public String getOtherArtists() {
    return otherArtists;
  }

  public void setOtherArtists(String otherArtists) {
    this.otherArtists = otherArtists;
  }
}
