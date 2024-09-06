package com.lopit.culturallifeoftranscarpathia.presentation.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class HomeController {

  @FXML
  private TextArea historyTextArea;

  @FXML
  public void initialize() {
    // Завантажте текст з історією Закарпаття
    String historyText = "Історія Закарпаття починається з давніх часів...";
    // Встановіть текст в TextArea
    historyTextArea.setText(historyText);
  }
}
