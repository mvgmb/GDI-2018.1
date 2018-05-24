package stat.control;

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
import stat.model.ModelManager;
import stat.model.Processo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class SearchLayoutController {
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
        //numero.getText();
    }
    @FXML
    void procurarProcesso(){
        //TODO procurar o processo com o numero:
        //textoPesquisa.getText();
        try {
            Processo p = ModelManager.manager.fetchProcesso(textoPesquisa.getText());
            this.SetLabelsAndImage(p, "teste");

        }
        catch (SQLException e) {
            //TODO mostrar alert de erro
        }
        catch (FileNotFoundException e) {
            //TODO mostrar alert de erro
        }


        //TODO mostrar resultado da pesquisa fazendo a seguinte chamada, onde os atributos são frutos da pesquisa:
        //SetLabels(new Processo(numero, tipo, dataRedacao, controladoria, urlDaImagem));
    }

    void SetLabelsAndImage(Processo p, String url) throws FileNotFoundException {
        numero.setText(p.getNumero());
        tipo.setText(p.getTipo());
        dataRedacao.setText(p.getDataRedacao());
        controladoria.setText(p.getControladoria());
        imagem.setImage(new Image(new FileInputStream(url),120,160,true,false));
    }

    public void setMainRef(MainApp mainRef){ this.mainRef = mainRef; }
}
