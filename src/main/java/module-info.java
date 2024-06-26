module com.lopit.culturallifeoftranscarpathia {
  requires javafx.controls;
  requires javafx.fxml;
  requires atlantafx.base;
  requires com.zaxxer.hikari;
  requires java.sql;
  requires com.sothawo.mapjfx;

  opens com.lopit.culturallifeoftranscarpathia to javafx.fxml;
  exports com.lopit.culturallifeoftranscarpathia;
  exports com.lopit.culturallifeoftranscarpathia.presentation.controller;
  opens com.lopit.culturallifeoftranscarpathia.presentation.controller to javafx.fxml;
}