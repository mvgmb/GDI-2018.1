package stat.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import stat.MainApp;
import stat.model.Processo;

import java.io.File;

public class InsertLayoutController {
    private MainApp mainRef;
    private FileChooser fileChooser;
    private File file;
    @FXML
    TextField numero;
    @FXML
    TextField tipo;
    @FXML
    TextField dataRedacao;
    @FXML
    TextField controladoria;
    @FXML
    ImageView imagem;
    @FXML
    Label url;
    @FXML
    Button photoBtn;
    @FXML
    Button okBtn;
    @FXML
    Button cancelBtn;
    @FXML
    private void pickPhoto(ActionEvent e){
        //Declare File Chooser
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Files", "*.*"),
                new FileChooser.ExtensionFilter("Pdf Files (.pdf)", "*.pdf"),
                new FileChooser.ExtensionFilter("Text Files (.txt)", "*.txt"),
                new FileChooser.ExtensionFilter("WinRAR Files (.rar)", "*.rar"),
                new FileChooser.ExtensionFilter("JPeg Files (.jpeg)", "*.jpeg")
        );
        fileChooser.setTitle("File Chooser Dialog");
        file = fileChooser.showOpenDialog(((Node) e.getSource()).getScene().getWindow());
        url.setText(file.getAbsolutePath());
    }
    @FXML
    private void cancelInsertion(ActionEvent e){
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(mainRef.searchScene);
        stage.show();
    }
    @FXML
    private void addProcesso(){
        //Caso todas as informações não tenham sido escritas, alertar ao usuario
        if (numero.getText().isEmpty() ||
            tipo.getText().isEmpty() ||
            dataRedacao.getText().isEmpty() ||
            controladoria.getText().isEmpty() ||
            url.getText().equals("Imagem URL")) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerta");
            alert.setHeaderText("Dados Incompletos!");
            alert.setContentText("Favor preencher todos os campos");
            alert.showAndWait();
        }

        Processo p = new Processo(numero.getText(), tipo.getText(), dataRedacao.getText(), controladoria.getText());

        //TODO adicionar processo p ao banco e dados

        //TODO adicionar imagem (setada em file) no banco de dados
        //file.getAbsolutePath(); retorna o url do arquivo
    }

    //Cleans every TextField
    public void cleanText(){
        setText("","","","");
    }
    public void setText(String numero, String tipo, String dataRedacao, String controladoria){
        this.numero.setText(numero);
        this.tipo.setText(tipo);
        this.dataRedacao.setText(dataRedacao);
        this.controladoria.setText(controladoria);
    }

    //Set MainApp reference
    public void setMainRef(MainApp mainRef){ this.mainRef = mainRef; }
}
