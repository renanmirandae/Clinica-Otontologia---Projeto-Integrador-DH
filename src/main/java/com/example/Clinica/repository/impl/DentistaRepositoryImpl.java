package com.example.Clinica.repository.impl;

import com.example.Clinica.repository.ConfigurarJDBC;
import com.example.Clinica.repository.IDao;
import com.example.Clinica.entity.DentistaEntity;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Repository
@Configuration
public class DentistaRepositoryImpl implements IDao<DentistaEntity> {
    private ConfigurarJDBC configurarJDBC;
    private Logger logger = Logger.getLogger(DentistaRepositoryImpl.class);

    public DentistaRepositoryImpl(ConfigurarJDBC configurarJDBC) {
        this.configurarJDBC = configurarJDBC;
    }

    @Override
    //Metodo reponsavel por cadastrar um novo dentista
    public DentistaEntity cadastrar(DentistaEntity dentista) {
        String sqlInsert = String.format("insert into dentista(nome, sobrenome, matricula, senha, tipo) values('%s', '%s', '%s','%s','%s');",
                dentista.getNome(), dentista.getSobrenome(), dentista.getDocumento(), dentista.getSenha(), dentista.getTipo());

        Connection connection = null;
        Statement statement = null;

        try
        {
            logger.info("Acessando banco de dados para cadastrar novo dentista");
            connection = configurarJDBC.conectarBanco();
            statement = connection.createStatement();
            statement.executeUpdate(sqlInsert, Statement.RETURN_GENERATED_KEYS);

            ResultSet key = statement.getGeneratedKeys();

            if(key.next())
            {
                dentista.setId(key.getInt(1));
            }

            logger.info("Dentista cadastrado com sucesso");

        }catch(SQLException error)
        {
            logger.error("Erro ao cadastrar novo dentista");
            error.printStackTrace();
        }

        return dentista;
    }

    @Override
    public void atualizar(int id) {
    }

    @Override
    //Metodo responsavel por excluir um dentista, passando sua matricula
    public void excluirPorDocumento(String documento) {
        String sqlDelete = String.format("delete from dentista where matricula='%s';", documento);
        Connection connection;
        Statement statement;
        try
        {
            logger.info("Acessando o banco de dados para excluir Dentista");
            connection = getConfigurarJDBC().conectarBanco();
            statement = connection.createStatement();
            statement.executeUpdate(sqlDelete);
            logger.info("Dentista excluido com sucesso");

        }catch(SQLException error)
        {
            logger.error("Erro ao excluir dentista");
            error.printStackTrace();
        }
    }

    @Override
    //Esse metodo retorna uma lista com os dentista que atende o parametro passado
    public List<DentistaEntity> buscarPorNome(String nome) throws SQLException
    {
        System.out.println("\"São Paulo\", \"Rio de Janeiro\"");
        logger.info("Acessando banco de dados para buscar dentista por nome");
        String sqlSelect = String.format("select * from dentista where nome='%s' ", nome);
        Connection connection;
        Statement statement;
        List<DentistaEntity> dentista = new ArrayList<>();
        try
        {
            connection = getConfigurarJDBC().conectarBanco();
            statement = connection.createStatement();

            ResultSet resultado = statement.executeQuery(sqlSelect);

            while(resultado.next())
            {
                dentista.add(criarObjDentista(resultado));
            }
            logger.info("Dentista encontrado com sucesso");
        }catch(SQLException error)
        {
            logger.error("Erro ao buscar dentista por nome.");
            error.printStackTrace();
        }
        return dentista;
    }

    private DentistaEntity criarObjDentista(ResultSet resultado) throws SQLException
    {
        logger.debug("Classe criar OBJ dentista");
        int id = resultado.getInt(1);
        String nome = resultado.getString(2);
        String sobrenome = resultado.getString(3);
        String documento = resultado.getString(4);
        String tipo = resultado.getString(6);


        return new DentistaEntity(id, nome, sobrenome, documento, null, tipo);
    }
}
