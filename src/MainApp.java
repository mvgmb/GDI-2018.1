import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application{

    Stage stage;
    Scene loadingScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Load LoadingLayout
        this.stage = primaryStage;
        System.out.println(stage);
        FXMLLoader loadingLayoutLoader = new FXMLLoader(getClass().getResource("view/LoadingLayout.fxml"));
        Parent loadingPane = loadingLayoutLoader.load();
        this.loadingScene = new Scene(loadingPane);

        //Set LoadingLayout scene
        primaryStage.setTitle("Projeto de InfraCom - mvgmb e mlbas");
        primaryStage.setScene(getLoadingScene());
        primaryStage.show();
    }

    //Main calls start function
    public static void main(String[] args) {
        launch(args);
    }

    //Scene gets
    public Scene getLoadingScene() {return loadingScene;}
}
