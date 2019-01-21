package com.udemy.cursouml;

import com.udemy.cursouml.domain.Categoria;
import com.udemy.cursouml.models.Produto;
import com.udemy.cursouml.repositories.CategoriaRepository;
import com.udemy.cursouml.repositories.ProdutoRepository;
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

    @Autowired
    private ProdutoRepository produtoRepository;
    public static void main(String[] args) {
        SpringApplication.run(CursoumlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Informatica");
        Categoria cat2 = new Categoria(null, "Escritorio");
        Produto p1 = new Produto(null, "computador", 2000.00);
        Produto p2 = new Produto(null, "impressora", 300.00);
        Produto p3 = new Produto(null, "mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1,p2, p3));
    }
}

