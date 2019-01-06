package com.udemy.cursouml;

import com.udemy.cursouml.domain.Categoria;
import com.udemy.cursouml.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

/**
 * CommandLineRunner executa uma acao antes de subir a aplicacao
 */
@SpringBootApplication
public class CursoumlApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursoumlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Informatica");
        Categoria cat2 = new Categoria(null, "Escritorio");
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
    }
}

