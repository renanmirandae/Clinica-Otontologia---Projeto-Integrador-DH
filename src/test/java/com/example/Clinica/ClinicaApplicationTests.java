package com.example.Clinica;

import com.example.Clinica.dao.ConfigurarJDBC;
import com.example.Clinica.dao.implementacao.DentistaDaoH2;
import com.example.Clinica.model.Dentista;
import com.example.Clinica.service.DentistaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
class ClinicaApplicationTests {

	Dentista marcos;
	DentistaService dentistaService;

	@BeforeEach
	void carregamento()
	{
		dentistaService = new DentistaService(new DentistaDaoH2(new ConfigurarJDBC()));
		marcos = new Dentista("Marcos", "Santos", "258652145", "marcos123", "administrador");

	}

	@Test
	void addDentista()
	{
		try {
			dentistaService.cadastrar(marcos);
		}catch (SQLException error)
		{
			error.printStackTrace();
		}
	}
}
