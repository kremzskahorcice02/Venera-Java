package com.example.venera.services;

import com.example.venera.models.Event;
import com.example.venera.models.dtos.EventDto;
import com.example.venera.repositories.EventRepository;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public int getYear() {
        return  LocalDate.now().getYear();
    }

    public List<EventDto> getEvents() {
        return eventsToDtos(eventRepository.findAllByOrderByDateDesc());
    }
    public List<EventDto> getFutureEvents() {
        List<Event> events = eventRepository.findAllByOrderByDateDesc();
        Date today = new Date();
        events = events.stream().filter(e -> e.getDate().compareTo(today) >= 0).collect(Collectors.toList());
        return eventsToDtos(events);
    }

    public List<EventDto> getPreviousEvents() {
        List<Event> events = eventRepository.findAllByOrderByDateDesc();
        Date today = new Date();
        events = events.stream().filter(e -> e.getDate().compareTo(today) < 0).collect(Collectors.toList());
        return eventsToDtos(events);
    }

    public List<EventDto> eventsToDtos(List<Event> events) {
        List<EventDto> eventDtos = new ArrayList<>();
        events.forEach(e -> eventDtos.add(new EventDto(e)));
        return eventDtos;
    }

    public void addEvent(String title, String date, String city, String place, String otherArtists, String url) {
        eventRepository.save(new Event(title, date,  city, place, otherArtists, url));
    }
}
