package com.lopit.culturallifeoftranscarpathia.persistence.repository.contract;

import com.lopit.culturallifeoftranscarpathia.domain.exception.EntityNotFoundException;
import com.lopit.culturallifeoftranscarpathia.persistence.entity.Category;
import com.lopit.culturallifeoftranscarpathia.persistence.entity.Event;
import java.util.List;

public interface EventsRepository {

  int addEvent(Event event);

  void updateEvent(Event event) throws EntityNotFoundException;

  void deleteEvent(int id_event) throws EntityNotFoundException;

  List<Event> findAll();

  List<Category> getCategoriesByEventId(int id_event);

  void addCategoryToEvent(int id_event, int categoryId) throws EntityNotFoundException;

  void removeCategoryFromEvent(int id_event, int categoryId) throws EntityNotFoundException;

  void addSavedEvent(int userId, int id_event);

  List<Event> findSavedEventsByUserId(int userId);

  void removeSavedEvent(int userId, int EventId) throws EntityNotFoundException;
}
