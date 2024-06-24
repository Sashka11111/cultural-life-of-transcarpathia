package com.lopit.culturallifeoftranscarpathia.presentation.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class AuthRegistrationController {

  @FXML
  private ResourceBundle resources;

  @FXML
  private URL location;

  @FXML
  private Button btnLogin;

  @FXML
  private Button btnSideCreate;

  @FXML
  private Button btn_signUp;

  @FXML
  private ImageView imageView;

  @FXML
  private AnchorPane loginForm;

  @FXML
  private PasswordField loginPassword;

  @FXML
  private TextField loginUsername;

  @FXML
  private AnchorPane registerForm;

  @FXML
  private AnchorPane sideForm;

  @FXML
  private Button side_alreadyHave;

  @FXML
  private PasswordField su_password;

  @FXML
  private TextField su_username;

  public void switchForm(ActionEvent event) {
    TranslateTransition slider = new TranslateTransition();
    if (event.getSource() == btnSideCreate) {
      slider.setNode(sideForm);
      slider.setToX(300);
      slider.setDuration(Duration.seconds(.5));

      slider.setOnFinished((ActionEvent e) -> {
        side_alreadyHave.setVisible(true);
        btnSideCreate.setVisible(false);
      });
      slider.play();
    } else if (event.getSource() == side_alreadyHave) {
      slider.setNode(sideForm);
      slider.setToX(0);
      slider.setDuration(Duration.seconds(.5));

      slider.setOnFinished((ActionEvent e) -> {
        side_alreadyHave.setVisible(false);
        btnSideCreate.setVisible(true);
      });
      slider.play();
    }
  }


}
