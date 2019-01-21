package com.udemy.cursouml.repositories;

import com.udemy.cursouml.domain.Categoria;
import com.udemy.cursouml.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
