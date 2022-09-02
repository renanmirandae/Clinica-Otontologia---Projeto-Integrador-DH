package com.example.Clinica.controller;

import com.example.Clinica.entity.DentistaEntity;
import com.example.Clinica.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;

@RestController()
@RequestMapping("/dentista")
public class DentistaController {
    @Autowired
    DentistaService dentistaService;

    @PostMapping()
    //Cadastrando novo dentista
    public DentistaEntity cadastrarDentista(@RequestBody DentistaEntity dentista) throws SQLException
    {
        return dentistaService.cadastrar(dentista);
    }

    @GetMapping(path = "/buscar")
    public String buscarPorMatricula()
    {
        return null;
    }

    @DeleteMapping
    //Excluindo dentista pelo numero da matricula passado como parametro
    public void excluirDentista(@RequestParam("documento") String documento) throws SQLException
    {
        dentistaService.excluirPorDocumento(documento);
    }
}
