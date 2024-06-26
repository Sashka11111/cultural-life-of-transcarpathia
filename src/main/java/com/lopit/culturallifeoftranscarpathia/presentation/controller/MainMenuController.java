package com.lopit.culturallifeoftranscarpathia.presentation.controller;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
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
  private AnchorPane sidebar;
  @FXML
  private StackPane stackPane;
  @FXML
  private StackPane contentArea;
  @FXML
  private Button menuButton;

  private boolean isSidebarOpen = false;

  @FXML
  public void initialize() {
    // Встановити початкову позицію панелі
    sidebar.setTranslateX(-180);

    btnHome.setOnAction(event -> {
      showHomePage();
    });/*
        btn_myGoals.setOnAction(event -> showMyGoalPage());
        btn_completeGoal.setOnAction(event -> showCompleteGoalsPage());
        btn_category.setOnAction(actionEvent -> showCategoryPage());
        btn_steps.setOnAction(event -> showStepsToGoalPage());*/
  }

  @FXML
  private void toggleSidebar() {
    TranslateTransition transition = new TranslateTransition(Duration.millis(300), sidebar);
    if (isSidebarOpen) {
      transition.setToX(-sidebar.getWidth());
      isSidebarOpen = false;
    } else {
      transition.setToX(0);
      isSidebarOpen = true;
    }
    transition.play();
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

  private void loadFXML(String fxmlFileName) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
      Parent fxml = loader.load();
      contentArea.getChildren().setAll(fxml);
    } catch (IOException ex) {
      Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void home() {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("view/home.fxml"));
      AnchorPane anchorPane = loader.load();
      HomeController homeController = loader.getController();
      contentArea.getChildren().clear();
      contentArea.getChildren().add(anchorPane);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
