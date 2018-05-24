package stat.control;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import stat.MainApp;
import stat.model.ModelManager;
import stat.model.Processo;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.sql.SQLException;

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
    BorderPane bp;
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
    private void pickPhoto(ActionEvent e) throws FileNotFoundException {
        //Declare File Chooser
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Files", "*.*"),
                new FileChooser.ExtensionFilter("Pdf Files (.pdf)", "*.pdf"),
                new FileChooser.ExtensionFilter("JPeg Files (.jpeg)", "*.jpeg")
        );
        fileChooser.setTitle("Choose File");
        file = fileChooser.showOpenDialog(((Node) e.getSource()).getScene().getWindow());
        url.setText(file.getAbsolutePath());

        imagem.setPreserveRatio(true);
        imagem.setImage(new Image(new FileInputStream(file.getAbsolutePath()), 120, 160, true, false));
    }
    @FXML
    private void cancelInsertion(ActionEvent e){
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(mainRef.searchScene);
        stage.show();
    }
    @FXML
    private void addProcesso(){
        byte[] arquivo = new byte[0];
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

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        RenderedImage bf = (RenderedImage) SwingFXUtils.fromFXImage(imagem.getImage(), null );
        try {
            ImageIO.write(bf, "png", os);
            arquivo = os.toByteArray();
        }
        catch (IOException e) {
            //TODO - Error Alert
        }



        Processo p = new Processo(numero.getText(), tipo.getText(), dataRedacao.getText(), controladoria.getText(), arquivo);
        try {
            ModelManager.manager.insertProcesso(p);
        }
        catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Ocorreu um erro na consulta");
            alert.setContentText("Favor checar todos os campos");
            alert.showAndWait();
        }

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
        this.url.setText("Imagem URL");
    }

    public void centerImage() {
        Image img = imagem.getImage();
        if (img != null) {
            double w = 0;
            double h = 0;

            double ratioX = imagem.getFitWidth() / img.getWidth();
            double ratioY = imagem.getFitHeight() / img.getHeight();

            double reducCoeff = 0;
            if(ratioX >= ratioY) {
                reducCoeff = ratioY;
            } else {
                reducCoeff = ratioX;
            }

            w = img.getWidth() * reducCoeff;
            h = img.getHeight() * reducCoeff;

            imagem.setX((imagem.getFitWidth() - w) / 2);
            imagem.setY((imagem.getFitHeight() - h) / 2);

        }
    }

    //Set MainApp reference
    public void setMainRef(MainApp mainRef){ this.mainRef = mainRef; }
}
