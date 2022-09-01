package com.example.Clinica.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T>{
    public T cadastrar(T t);
    public void atualizar(int id) throws SQLException;
    public void excluirPorDocumento(String documento) throws SQLException;
    public List<T> buscarPorDocumento(String documento) throws SQLException;
}
