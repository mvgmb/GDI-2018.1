package stat.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ModelManager {

    private Connection connection;

    public static ModelManager manager = new ModelManager();

    public ModelManager() {
    }

    public void accessDB() {
        String url = "jdbc:oracle:thin:@oracle11g.cin.ufpe.br:1521:Instance01";
        try {
            connection = DriverManager.getConnection(url, "g181if685cc_eq03", "mriknlwk");

        } catch (SQLException e) {
            System.out.println("PASSEI AQUI, DOIDERA");
        }
    }

//    public void fetchProcesso() {
////        String createSQL = "CREATE TABLE Pessoa2 (Nome varchar(255))";
////        String insertPessoa = "INSERT INTO Pessoa2 (Nome) values ('Vinicius')";
////        String consultaSQL = "SELECT * FROM Pessoa2";
//
//        Statement stmt = connection.createStatement();
//        //ResultSet createResult = stmt.executeQuery(createSQL);
//        //ResultSet insertResult = stmt.executeQuery(insertPessoa);
//        ResultSet queryResult = stmt.executeQuery(consultaSQL);
//
//        while(queryResult.next())
//        {
//            System.out.println(queryResult.getString(1));
//        }
//    }

    public Processo fetchProcesso(String numEnt) throws SQLException {
        //nao sei exatamente como funcionara o resultado da pesquisa, mas eh coisa simples de corrigir (colocando como retorno ou colocando no parametro)
        String numero;
        String tipo;
        String controladoria;
        String data_de_redacao;
        Processo p = null;

        Statement stmt = null;
        String query = "SELECT numero, tipo, controladoria, data_de_redacao FROM Processo WHERE numero = '" + numEnt + "'";
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                numero = rs.getString("numero");
                tipo = rs.getString("tipo");
                controladoria = rs.getString("controladoria");
                data_de_redacao = rs.getString("data_de_redacao");
                p = new Processo(numero, tipo, data_de_redacao, controladoria);
                System.out.println(numero + "  " + controladoria);
            }
        } catch (SQLException e ) {
//            JDBCTutorialUtilities.printSQLException(e);
            System.out.println(e.getMessage());
        } finally {
            if (stmt != null) { stmt.close(); }
        }
        return p;

    }

    public List<Processo> fetchAllProcessos() throws SQLException {
        String numero;
        String tipo;
        String controladoria;
        String data_de_redacao;

        List<Processo> processos = new ArrayList<Processo>();

        Statement stmt = null;
        String query = "SELECT numero, tipo, controladoria, data_de_redacao FROM Processo";
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                numero = rs.getString("numero");
                tipo = rs.getString("tipo");
                controladoria = rs.getString("controladoria");
                data_de_redacao = rs.getString("data_de_redacao");

                Processo p = new Processo(numero, tipo, data_de_redacao, controladoria);
                processos.add(p);
                System.out.println(numero + "  " + controladoria);
            }
        } catch (SQLException e ) {
            throw e;
        } finally {
            if (stmt != null) { stmt.close(); }
        }
        return processos;

    }

    public void insertProcesso(Processo p) throws SQLException {
        Statement stmt = null;
        String preQuery = "INSERT INTO Processo (numero, tipo, controladoria, data_de_redacao) VALUES ('%s', '%s', '%s', '%s')";
        String query = String.format(preQuery, p.getNumero(), p.getTipo(), p.getControladoria(), p.getDataRedacao());
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
//
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if (stmt != null) { stmt.close(); }
        }

    }

    public void createTable() {
        String query = "CREATE TABLE Processo(numero VARCHAR2(50) NOT NULL, tipo VARCHAR2(50) NOT NULL, data_de_redacao VARCHAR2(10) NOT NULL, controladoria VARCHAR2(18) NOT NULL, arquivo BLOB, CONSTRAINT processo_pk PRIMARY KEY (numero))";

        try {
            Statement stmt = connection.createStatement();
            stmt.executeQuery(query);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

}
