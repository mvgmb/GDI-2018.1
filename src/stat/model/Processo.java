package stat.model;

import javafx.beans.property.SimpleStringProperty;

public class Processo {
    private final SimpleStringProperty numero;
    private final SimpleStringProperty tipo;
    private final SimpleStringProperty dataRedacao;
    private final SimpleStringProperty controladoria;

    public Processo(String numero, String tipo, String dataRedacao, String cpfFuncionario){
        this.numero = new SimpleStringProperty(numero);
        this.tipo = new SimpleStringProperty(tipo);
        this.dataRedacao = new SimpleStringProperty(dataRedacao);
        this.controladoria = new SimpleStringProperty(cpfFuncionario);
    }

    public String getNumero() {
        return numero.get();
    }

    public SimpleStringProperty numeroProperty() {
        return numero;
    }

    public String getTipo() {
        return tipo.get();
    }

    public SimpleStringProperty tipoProperty() {
        return tipo;
    }

    public String getDataRedacao() {
        return dataRedacao.get();
    }

    public SimpleStringProperty dataRedacaoProperty() {
        return dataRedacao;
    }

    public String getControladoria() {
        return controladoria.get();
    }

    public SimpleStringProperty controladoriaProperty() {
        return controladoria;
    }
}
