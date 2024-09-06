package com.lopit.culturallifeoftranscarpathia.persistence.entity;

import java.time.LocalDate;

public record Event(
    int id_event,
    String title,
    String description,
    LocalDate date,
    String location) implements Comparable<Event> {

  @Override
  public int compareTo(Event o) {
    return Integer.compare(this.id_event, o.id_event);
  }
}
