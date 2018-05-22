package model;

import javafx.beans.property.SimpleStringProperty;

public class Funcionario {
    private final SimpleStringProperty cpf;
    private final SimpleStringProperty nome;
    private final SimpleStringProperty salario;
    private final SimpleStringProperty dataDeNascimento;
    private final SimpleStringProperty cpfDoSupervisionador;
    //endereço
    private final SimpleStringProperty cep;
    private final SimpleStringProperty pais;
    private final SimpleStringProperty estado;
    private final SimpleStringProperty bairro;
    private final SimpleStringProperty complemento;
    private final SimpleStringProperty numero;
    private final SimpleStringProperty rua;

    private Funcionario(
            String cpf,
            String nome,
            String salario,
            String dataDeNascimento,
            String cpfDoSupervisionador,
            String cep,
            String pais,
            String estado,
            String bairro,
            String complemento,
            String numero,
            String rua) {
        this.cpf = new SimpleStringProperty(cpf);
        this.nome = new SimpleStringProperty(nome);
        this.salario = new SimpleStringProperty(salario);
        this.dataDeNascimento = new SimpleStringProperty(dataDeNascimento);
        this.cpfDoSupervisionador = new SimpleStringProperty(cpfDoSupervisionador);
        this.cep = new SimpleStringProperty(cep);
        this.pais = new SimpleStringProperty(pais);
        this.estado = new SimpleStringProperty(estado);
        this.bairro = new SimpleStringProperty(bairro);
        this.complemento = new SimpleStringProperty(complemento);
        this.numero = new SimpleStringProperty(numero);
        this.rua = new SimpleStringProperty(rua);
    }

    public String getCpf() { return cpf.get(); }
    public SimpleStringProperty cpfProperty() { return cpf; }

    public String getNome() { return this.nome.get(); }
    public void setNome(String nome) { this.nome.set(nome); }

    public String getSalario() { return salario.get();}
    public SimpleStringProperty salarioProperty() { return salario; }

    public String getDataDeNascimento() { return dataDeNascimento.get(); }
    public SimpleStringProperty dataDeNascimentoProperty() { return dataDeNascimento; }

    public String getCpfDoSupervisionador() { return cpfDoSupervisionador.get(); }
    public SimpleStringProperty cpfDoSupervisionadorProperty() { return cpfDoSupervisionador; }

    public String getCep() { return cep.get(); }
    public SimpleStringProperty cepProperty() { return cep; }

    public String getPais() { return pais.get(); }
    public SimpleStringProperty paisProperty() { return pais; }

    public String getEstado() { return estado.get(); }
    public SimpleStringProperty estadoProperty() { return estado; }

    public String getBairro() { return bairro.get(); }
    public SimpleStringProperty bairroProperty() { return bairro; }

    public String getComplemento() { return complemento.get(); }
    public SimpleStringProperty complementoProperty() { return complemento; }

    public String getNumero() { return numero.get(); }
    public SimpleStringProperty numeroProperty() { return numero; }

    public String getRua() { return rua.get(); }
    public SimpleStringProperty ruaProperty() { return rua; }
}
