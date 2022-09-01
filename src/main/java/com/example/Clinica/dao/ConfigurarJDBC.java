package com.example.Clinica.dao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Getter
@Setter
@AllArgsConstructor
public class ConfigurarJDBC {
    private String driver, url, usuario, senha;
    private Logger logger = Logger.getLogger(ConfigurarJDBC.class);

    public ConfigurarJDBC() {
        this.driver = "org.h2.Driver";
        this.url = "jdbc:h2:~/test;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'create.sql'";
        this.usuario = "sa";
        this.senha = "";
    }

    public Connection conectarBanco()
    {
        logger.info("Abrindo conexao com o banco de dados");
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(this.url, this.usuario, this.senha);
        }catch(SQLException error)
        {
            logger.debug("Erro ao conectar com o banco na classe configurar JDBC");
            error.printStackTrace();
        }

        return connection;
    }
}
