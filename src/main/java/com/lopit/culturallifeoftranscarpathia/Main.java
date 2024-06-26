package com.lopit.culturallifeoftranscarpathia;

import atlantafx.base.theme.PrimerLight;
import com.lopit.culturallifeoftranscarpathia.persistence.connection.DatabaseConnection;
import java.util.Objects;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
  private static DatabaseConnection databaseConnection;

  @Override
  public void start(Stage primaryStage) throws IOException {
    Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());
    primaryStage.getIcons().add(new Image(
        Objects.requireNonNull(getClass().getResourceAsStream("/data/icon.png"))));
    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/mainMenu.fxml"));
    Parent root = fxmlLoader.load();
    primaryStage.setTitle("Культурне життя Закарпаття");
    primaryStage.setScene(new Scene(root, 1100, 700));
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  @Override
  public void stop() throws Exception {
    super.stop();
    // Закриття пулу з'єднань під час зупинки додатка
    if (databaseConnection != null) {
      databaseConnection.closePool();
    }
  }

  public static void main(String[] args) {
    databaseConnection = DatabaseConnection.getInstance();
    try {
      databaseConnection.initializeDataSource();
      launch(args);
    } finally {
      // При завершенні роботи додатка також закриємо пул
      if (databaseConnection != null) {
        databaseConnection.closePool();
      }
    }
  }
}