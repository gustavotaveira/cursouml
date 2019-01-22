package com.udemy.cursouml;

import com.udemy.cursouml.domain.Categoria;
import com.udemy.cursouml.domain.Cidade;
import com.udemy.cursouml.domain.Estado;
import com.udemy.cursouml.domain.Produto;
import com.udemy.cursouml.repositories.CategoriaRepository;
import com.udemy.cursouml.repositories.CidadeRepository;
import com.udemy.cursouml.repositories.EstadoRepository;
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

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

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
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "Sao Paulo");

        Cidade c1 = new Cidade(null, "Uberlandia",est1);
        Cidade c2 = new Cidade(null, "Sao Paulo",est2);
        Cidade c3 = new Cidade(null, "Campinas",est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
    }
}

