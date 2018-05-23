package stat.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import stat.MainApp;
import stat.model.Processo;

public class InsertLayoutController {
    private MainApp mainRef;

    @FXML
    TextField numero;
    @FXML
    TextField tipo;
    @FXML
    TextField dataRedacao;
    @FXML
    TextField controladoria;
    @FXML
    Button photoBtn;
    @FXML
    Button okBtn;
    @FXML
    Button cancelBtn;
    @FXML
    private void pickPhoto(){
        //TODO escolher pdf do processo
        //TODO adicionar imagem com o url acima no banco de dados
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
            controladoria.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerta");
            alert.setHeaderText("Dados Incompletos!");
            alert.setContentText("Favor preencher todos os campos");
            alert.showAndWait();
        }

        Processo p = new Processo(numero.getText(), tipo.getText(), dataRedacao.getText(), controladoria.getText());

        //TODO adicionar processo p ao banco e dados
    }

    //Cleans every TextField
    public void cleanText(){
        numero.setText("");
        tipo.setText("");
        dataRedacao.setText("");
        controladoria.setText("");
        photoBtn.setText("");
        okBtn.setText("");
        cancelBtn.setText("");
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
