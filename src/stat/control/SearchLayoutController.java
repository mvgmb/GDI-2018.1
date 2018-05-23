package stat.control;

import javafx.scene.control.TextField;
import stat.MainApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import stat.model.Processo;

import java.io.IOException;

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
    Button pesquisarBtn;
    @FXML
    Button adicionarBtn;
    @FXML
    Button modificarBtn;
    @FXML
    Button removerBtn;
    @FXML
    void adicionarFuncionario(ActionEvent e) throws IOException {
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(mainRef.insertScene);
        mainRef.insertLayoutController.cleanText();
        stage.show();
    }
    @FXML
    void modificarFuncionario(ActionEvent e){
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(mainRef.insertScene);
        mainRef.insertLayoutController.cleanText();

        //Como os dados vão ser atualizados, a tela de insercao/modificacao será carregada com os valores atuais do processo
        mainRef.insertLayoutController.setText(numero.getText(), tipo.getText(), dataRedacao.getText(), controladoria.getText());

        stage.show();
    }
    @FXML
    void removerFuncionario(){
        //TODO remover processo com o numero:
        //numero.getText();
    }
    @FXML
    void procurarFuncionario(){
        //TODO procurar o processo com o numero:
        //textoPesquisa.getText();

        //TODO mostrar resultado da pesquisa fazendo a seguinte chamada, onde os atributos são frutos da pesquisa:
        //SetLabels(new Processo(numero, tipo, dataRedacao, controladoria));
    }

    void SetLabels(Processo p){
        numero.setText(p.getNumero());
        tipo.setText(p.getTipo());
        dataRedacao.setText(p.getDataRedacao());
        controladoria.setText(p.getControladoria());
    }

    public void setMainRef(MainApp mainRef){ this.mainRef = mainRef; }
}
