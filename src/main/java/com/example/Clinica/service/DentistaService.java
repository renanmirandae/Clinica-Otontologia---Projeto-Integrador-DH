package com.example.Clinica.service;

import com.example.Clinica.repository.IDao;
import com.example.Clinica.entity.DentistaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
@Service
public class DentistaService {
    @Autowired
    IDao<DentistaEntity> dentistaDao;

    public DentistaService(IDao<DentistaEntity> dentistaDao) {
        this.dentistaDao = dentistaDao;
    }

    public DentistaEntity cadastrar(DentistaEntity dentista) throws SQLException{
        return dentistaDao.cadastrar(dentista);
    }

    public void excluirPorDocumento(String documento) throws SQLException
    {
        this.dentistaDao.excluirPorDocumento(documento);
    }
}
