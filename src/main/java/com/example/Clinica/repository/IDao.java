package com.example.Clinica.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IDao<T>{
    public T cadastrar(T t);
    public void atualizar(int id) throws SQLException;
    public void excluirPorDocumento(String documento) throws SQLException;
    public List<T> buscarPorNome(String nome) throws SQLException;
}
