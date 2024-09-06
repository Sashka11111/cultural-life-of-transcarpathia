package com.lopit.culturallifeoftranscarpathia.presentation.controller;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainMenuController {

  @FXML
  private Button btnHome;
  @FXML
  private Button btnCategory;
  @FXML
  private Button btnEvents;
  @FXML
  private Button btnProfile;
  @FXML
  private Button btnVenues;
  @FXML
  private StackPane stackPane;
  @FXML
  private StackPane contentArea;



  @FXML
  public void initialize() {
    showHomePage();
    btnHome.setOnAction(event -> showHomePage());
    btnCategory.setOnAction(event -> showCategoryPage());
    btnEvents.setOnAction(event -> showEventsPage());
    btnProfile.setOnAction(event -> showProfilePage());
    btnVenues.setOnAction(event -> showVenuesPage());
  }

  private void moveStackPane(Button button) {
    double buttonX = button.localToParent(button.getBoundsInLocal()).getMinX();
    double buttonY = button.localToParent(button.getBoundsInLocal()).getMinY();
    TranslateTransition transition = new TranslateTransition(Duration.seconds(0.3), stackPane);
    transition.setToX(buttonX);
    stackPane.setLayoutY(buttonY);
  }


  private void showHomePage() {
    moveStackPane(btnHome);
    loadFXML("/view/home.fxml");
  }

  private void showCategoryPage() {
    moveStackPane(btnCategory);
    loadFXML("/view/category.fxml");
  }

  private void showEventsPage() {
    moveStackPane(btnEvents);
    loadFXML("/view/events.fxml");
  }

  private void showProfilePage() {
    moveStackPane(btnProfile);
    loadFXML("/view/profile.fxml");
  }

  private void showVenuesPage() {
    moveStackPane(btnVenues);
    loadFXML("/view/venues.fxml");
  }

  private void loadFXML(String fxmlFileName) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
      Parent fxml = loader.load();
      contentArea.getChildren().setAll(fxml);
    } catch (IOException ex) {
      Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

}
