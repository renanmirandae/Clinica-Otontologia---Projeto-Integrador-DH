package com.example.Clinica.service;

import com.example.Clinica.dao.IDao;
import com.example.Clinica.model.Dentista;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
public class DentistaService {
    IDao<Dentista> dentistaDao;

    public DentistaService(IDao<Dentista> dentistaDao) {
        this.dentistaDao = dentistaDao;
    }

    public Dentista cadastrar(Dentista dentista) throws SQLException{
        return dentistaDao.cadastrar(dentista);
    }
}
