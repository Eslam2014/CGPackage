package cgui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainWindow.fxml"));
		GridPane root = loader.load();
		Scene scene = new Scene(root, 600, 450);
		primaryStage.setTitle("Computational Geometry - Starte");
		MainWindowController myController = loader.getController();

		scene.setOnKeyPressed(e -> {

			if (e.getCode() == KeyCode.CONTROL) {
				try {
					myController.keyPressed();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		});

		scene.getStylesheets().add(getClass().getResource("/styles/style.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}