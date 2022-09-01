package com.example.Clinica.dao;

import java.util.List;

public interface IDao <T>{
    public T cadastrar(T t);
    public void atualizar(int id);
    public void excluirPorDocumento(String documento);
    public List<T> buscarPorDocumento(String documento);
}
