package com.oraclesample.oraclesec.repository;

import com.oraclesample.oraclesec.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
