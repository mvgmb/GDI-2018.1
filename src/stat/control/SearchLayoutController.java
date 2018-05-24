package stat.control;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import stat.MainApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import stat.model.AlertError;
import stat.model.ModelManager;
import stat.model.Processo;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class SearchLayoutController {
    Processo processo = null;

    MainApp mainRef;
    @FXML
    Label numero;
    @FXML
    Label tipo;
    @FXML
    Label dataRedacao;
    @FXML
    Label controladoria;
    @FXML
    TextField textoPesquisa;
    @FXML
    BorderPane bp;
    @FXML
    ImageView imagem;
    @FXML
    Button pesquisarBtn;
    @FXML
    Button adicionarBtn;
    @FXML
    Button modificarBtn;
    @FXML
    Button removerBtn;
    @FXML
    void adicionarProcesso(ActionEvent e) throws IOException {
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(mainRef.insertScene);
        mainRef.insertLayoutController.cleanText();
        mainRef.insertLayoutController.imagem.setImage(null);
        stage.show();
    }
    @FXML
    void modificarProcesso(ActionEvent e){
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(mainRef.insertScene);
        mainRef.insertLayoutController.cleanText();

        //Como os dados vão ser atualizados, a tela de insercao/modificacao será carregada com os valores atuais do processo
        mainRef.insertLayoutController.setText(numero.getText(), tipo.getText(), dataRedacao.getText(), controladoria.getText());

        stage.show();
    }
    @FXML
    void removerProcesso(){
        //TODO remover processo com o numero:
        try {
            if (processo != null) ModelManager.manager.deleteProcesso(processo);
        }
        catch (SQLException e) {
            //TODO - Handle error
        }

    }
    @FXML
    void procurarProcesso(){
        //TODO procurar o processo com o numero:

        try {
            processo = ModelManager.manager.fetchProcesso(textoPesquisa.getText());
            this.SetLabelsAndImage(processo, "teste");

        }
        catch (SQLException e) {
            new AlertError("Erro","Ocorreu um erro na consulta","Favor checar todos os campos.");
        }
        catch (FileNotFoundException e) {
            new AlertError("Erro","Ocorreu um erro na consulta","Favor checar se os campos foram inseridos.");
        }
    }

    void SetLabelsAndImage(Processo p, String url) throws FileNotFoundException {
        numero.setText(p.getNumero());
        tipo.setText(p.getTipo());
        dataRedacao.setText(p.getDataRedacao());
        controladoria.setText(p.getControladoria());
//        new Image();
        imagem.setImage(new Image(new ByteArrayInputStream(p.getArquivo()),120,160,true,false));
    }

    public void setMainRef(MainApp mainRef){ this.mainRef = mainRef; }
}
