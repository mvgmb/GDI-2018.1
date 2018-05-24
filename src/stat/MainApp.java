package stat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import stat.control.InsertLayoutController;
import stat.control.SearchLayoutController;
import stat.model.ModelManager;

public class MainApp extends Application{

    public Scene insertScene;
    public Scene searchScene;
    public SearchLayoutController searchLayoutController;
    public InsertLayoutController insertLayoutController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loadingLayoutLoader = new FXMLLoader(getClass().getResource("view/LoadingLayout.fxml"));
        Parent loadingPane = loadingLayoutLoader.load();
        Scene loadingScene = new Scene(loadingPane);

        //Set LoadingLayout scene
        primaryStage.setTitle("Projeto de GDI - 2018.1");
        primaryStage.setScene(loadingScene);
        primaryStage.show();

        //Load search and insert scene
        FXMLLoader searchLayoutLoader = new FXMLLoader(getClass().getResource("view/SearchLayout.fxml"));
        Parent searchPane = searchLayoutLoader.load();
        searchScene = new Scene(searchPane);

        FXMLLoader insertLayoutLoader = new FXMLLoader(getClass().getResource("view/InsertLayout.fxml"));
        Parent insertPane = insertLayoutLoader.load();
        insertScene = new Scene(insertPane);

        //Passing mainApp reference to the controllers
        searchLayoutController = (searchLayoutLoader.getController());
        insertLayoutController = (insertLayoutLoader.getController());
        searchLayoutController.setMainRef(this);
        insertLayoutController.setMainRef(this);

        primaryStage.setScene(searchScene);
        primaryStage.show();

        ModelManager.manager.accessDB();
//        ModelManager.manager.createTable();
        ModelManager.manager.fetchAllProcessos();
    }

    //Main calls start function
    public static void main(String[] args) {
        launch(args);
    }
}
