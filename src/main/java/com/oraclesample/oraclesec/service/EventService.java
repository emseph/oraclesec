package com.oraclesample.oraclesec.service;

import java.util.*;




import com.oraclesample.oraclesec.model.Event;
import com.oraclesample.oraclesec.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // Read
    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }

    // Create
    public void addEvent(Event event) {
        eventRepository.save(event);
    }

    // Delete
    public void removeEventById(int id) {
        eventRepository.deleteById(id);
    }

    // Update
    public Optional<Event> getEventById(int id) {
        return eventRepository.findById(id);
    }
}
