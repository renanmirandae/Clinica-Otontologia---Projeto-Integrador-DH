package com.example.Clinica;

import com.example.Clinica.repository.ConfigurarJDBC;
import com.example.Clinica.repository.impl.DentistaRepositoryImpl;
import com.example.Clinica.entity.DentistaEntity;
import com.example.Clinica.service.DentistaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
class ClinicaApplicationTests {

	DentistaEntity marcos, luiz, antonio, lara, maria;
	DentistaService dentistaService;

	@BeforeEach
	void carregamento()
	{
		dentistaService = new DentistaService(new DentistaRepositoryImpl(new ConfigurarJDBC()));
		marcos = new DentistaEntity("Marcos", "Santos", "258652145", "marcos123", "administrador");
		luiz = new DentistaEntity("Luiz", "Vasconselos", "15485258", "lv2022", "administrador");;
		antonio = new DentistaEntity("Antonio", "Wiliam", "145285695", "12345678", "administrador");;
		lara = new DentistaEntity("Lara", "Bittencourt", "00025852", "235467", "administrador");;
		maria = new DentistaEntity("Maria", "Graça", "12358620025", "maria12", "administrador");;

	}

	@Test
	void addDentista() throws SQLException
	{
		//dentistaService.cadastrar(marcos);
		//dentistaService.cadastrar(luiz);
		//dentistaService.cadastrar(antonio);
		//dentistaService.cadastrar(lara);
		//dentistaService.cadastrar(maria);
	}

	@Test
	void excluirDentista() throws SQLException
	{
		dentistaService.excluirPorDocumento("258652145");
	}
}
