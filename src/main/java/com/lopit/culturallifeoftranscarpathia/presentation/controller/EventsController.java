package com.lopit.culturallifeoftranscarpathia.presentation.controller;

import com.lopit.culturallifeoftranscarpathia.persistence.entity.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class EventsController {

  @FXML
  private DatePicker dateFilter;

  @FXML
  private ComboBox<String> categoryFilter;

  @FXML
  private TableView<Event> eventsTable;

  @FXML
  private TableColumn<Event, LocalDate> dateColumn;

  @FXML
  private TableColumn<Event, String> categoryColumn;

  @FXML
  private TableColumn<Event, String> nameColumn;

  @FXML
  private TableColumn<Event, String> locationColumn;

  @FXML
  private WebView mapView;

  private ObservableList<Event> events = FXCollections.observableArrayList();

  @FXML
  public void initialize() {
    // Ініціалізація колонок таблиці
//    dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
//    categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
//    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//    locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));

    // Ініціалізація фільтру категорій
    categoryFilter.setItems(FXCollections.observableArrayList("Музика", "Театр", "Мистецтво", "Фестиваль"));

//    // Завантаження початкових даних
//    loadSampleEvents();

    // Завантаження карти
    loadMap();
  }

//  private void loadSampleEvents() {
//    // Приклад подій, які ви можете завантажити з бази даних або файлу
//    events.addAll(
//        new Event(LocalDate.of(2024, 9, 10), "Музика", "Концерт симфонічної музики", "Ужгород, Площа Народна"),
//        new Event(LocalDate.of(2024, 9, 12), "Театр", "Вистава 'Гамлет'", "Мукачево, Театр драми"),
//        new Event(LocalDate.of(2024, 9, 14), "Мистецтво", "Виставка сучасного мистецтва", "Берегове, Галерея мистецтв"),
//        new Event(LocalDate.of(2024, 9, 20), "Фестиваль", "Фестиваль вина", "Виноградів, Площа Героїв")
//    );
//    eventsTable.setItems(events);
//  }

  @FXML
  private void applyFilters() {
    LocalDate selectedDate = dateFilter.getValue();
    String selectedCategory = categoryFilter.getValue();

    ObservableList<Event> filteredEvents = events.stream()
        .filter(event -> (selectedDate == null || event.date().equals(selectedDate)))
        .filter(event -> (selectedCategory == null || selectedCategory.equals(event.category())))
        .collect(Collectors.toCollection(FXCollections::observableArrayList));

    eventsTable.setItems(filteredEvents);
  }

  private void loadMap() {
    WebEngine webEngine = mapView.getEngine();
    // Завантаження карти з використанням Google Maps
    webEngine.load("https://www.google.com/maps");
  }
}
