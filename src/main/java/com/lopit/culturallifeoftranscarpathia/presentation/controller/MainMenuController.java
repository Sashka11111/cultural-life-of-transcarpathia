package com.lopit.culturallifeoftranscarpathia.presentation.controller;

import java.util.Objects;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
  private Button addUser;
  @FXML
  private AnchorPane sidebar;
  @FXML
  private StackPane stackPane;
  @FXML
  private StackPane contentArea;
  @FXML
  private Button menuButton;
  @FXML
  private AnchorPane contentContainer;

  private boolean isSidebarOpen = false;

  @FXML
  public void initialize() {
    // Set initial position of the sidebar
    sidebar.setTranslateX(-180);
    AnchorPane.setLeftAnchor(contentContainer, 0.0);
    AnchorPane.setRightAnchor(contentContainer, 0.0);
    showHomePage();
    btnHome.setOnAction(event -> showHomePage());
    btnCategory.setOnAction(event -> showCategoryPage());
    btnEvents.setOnAction(event -> showEventsPage());
    btnProfile.setOnAction(event -> showProfilePage());
    btnVenues.setOnAction(event -> showVenuesPage());
    addUser.setOnAction(event -> showRegistrationWindow());
  }

  @FXML
  private void toggleSidebar() {
    TranslateTransition transition = new TranslateTransition(Duration.millis(300), sidebar);
    if (isSidebarOpen) {
      transition.setToX(-178);
      isSidebarOpen = false;
      animateContentContainer(178.0, 0.0);
    } else {
      transition.setToX(0);
      isSidebarOpen = true;
      animateContentContainer(0.0, 178.0);
    }
    transition.play();
  }

  private void animateContentContainer(double fromX, double toX) {
    TranslateTransition transition = new TranslateTransition(Duration.millis(300), contentContainer);
    transition.setFromX(fromX);
    transition.setToX(toX);
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

  private void showRegistrationWindow() {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/auth_registration.fxml"));
      Parent root = loader.load();
      Stage stage = new Stage();
      stage.setScene(new Scene(root));
      stage.getIcons().add(new Image(
          Objects.requireNonNull(getClass().getResourceAsStream("/data/icon.png"))));
      stage.setTitle("Створення аккаунта");
      stage.setResizable(false);
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.initOwner(addUser.getScene().getWindow());
      stage.showAndWait();
    } catch (IOException ex) {
      Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
