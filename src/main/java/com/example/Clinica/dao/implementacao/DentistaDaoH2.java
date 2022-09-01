package com.example.Clinica.dao.implementacao;

import com.example.Clinica.dao.ConfigurarJDBC;
import com.example.Clinica.dao.IDao;
import com.example.Clinica.model.Dentista;
import lombok.Getter;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Getter
public class DentistaDaoH2 implements IDao<Dentista> {
    private ConfigurarJDBC configurarJDBC;
    private Logger logger = Logger.getLogger(DentistaDaoH2.class);

    @Override
    public Dentista cadastrar(Dentista dentista) {
        String sqlInsert = String.format("insert into dentista(nome, sobrenome, matricula) values('%s', '%s', '%s');",
                dentista.getNome(), dentista.getSobrenome(), dentista.getDocumento());

        Connection connection = null;
        Statement statement = null;

        try
        {
            logger.debug("Inserindo dados do dentista no banco de dados");
            connection = getConfigurarJDBC().conectarBanco();
            statement = connection.createStatement();
            statement.executeUpdate(sqlInsert);

        }catch(SQLException error)
        {
            logger.debug("Erro ao registrar dentista");
        }

        return dentista;
    }

    @Override
    public void atualizar(int id) {

    }

    @Override
    public void excluirPorDocumento(String documento) {
        String sqlDelete = String.format("delete from dentista where matricula='%s';", documento);
        Connection connection;
        Statement statement;
        try
        {
            logger.debug("Excluindo dentista");
            connection = getConfigurarJDBC().conectarBanco();
            statement = connection.createStatement();
            statement.executeUpdate(sqlDelete);

        }catch(SQLException error)
        {
            logger.debug("Erro ao excluir dentista");
        }
    }

    @Override
    public List<Dentista> buscarPorDocumento(String documento) {
        return null;
    }
}
