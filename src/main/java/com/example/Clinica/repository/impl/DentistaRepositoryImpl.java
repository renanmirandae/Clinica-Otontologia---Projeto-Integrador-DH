package com.example.Clinica.repository.impl;

import com.example.Clinica.repository.ConfigurarJDBC;
import com.example.Clinica.repository.IDao;
import com.example.Clinica.entity.DentistaEntity;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Getter
@Setter
@Repository
public class DentistaRepositoryImpl implements IDao<DentistaEntity> {
    private ConfigurarJDBC configurarJDBC;
    private Logger logger = Logger.getLogger(DentistaRepositoryImpl.class);

    public DentistaRepositoryImpl(ConfigurarJDBC configurarJDBC) {
        this.configurarJDBC = configurarJDBC;
    }

    @Override
    public DentistaEntity cadastrar(DentistaEntity dentista) {
        String sqlInsert = String.format("insert into dentista(nome, sobrenome, matricula, senha, tipo) values('%s', '%s', '%s','%s','%s');",
                dentista.getNome(), dentista.getSobrenome(), dentista.getDocumento(), dentista.getSenha(), dentista.getTipo());

        Connection connection = null;
        Statement statement = null;

        try
        {
            logger.debug("Inserindo dados do dentista no banco de dados");
            connection = configurarJDBC.conectarBanco();
            statement = connection.createStatement();
            statement.executeUpdate(sqlInsert, Statement.RETURN_GENERATED_KEYS);

        }catch(SQLException error)
        {
            logger.debug("Erro ao registrar dentista");
            error.printStackTrace();
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
            error.printStackTrace();
        }
    }

    @Override
    public List<DentistaEntity> buscarPorDocumento(String documento) {
        return null;
    }
}
