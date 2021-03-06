package co.mz.osoma.editor;

import co.mz.osoma.editor.controlador.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import co.mz.osoma.editor.controlador.MainGUIController;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private RootLayoutController rootLayoutController;

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Exames");

        initRootLayout();

        showExams();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vista/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            rootLayoutController = loader.getController();



            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);

//            scene.getStylesheets().add("co/mz/osoma/editor/vista/styles.css");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showExams(){

        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vista/MainGUI.fxml"));
            BorderPane examsPanel = (BorderPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(examsPanel);

            // Give the controller access to the main app.
            MainGUIController controller = loader.getController();

            rootLayoutController.setMainGUIController(controller);


            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
