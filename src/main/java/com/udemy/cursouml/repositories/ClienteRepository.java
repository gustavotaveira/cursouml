package com.udemy.cursouml.repositories;

import com.udemy.cursouml.domain.Cliente;
import com.udemy.cursouml.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Um objeto desse tipo realiza operacoes de acesso a dados referentes ao objeto categoria,
 * que esta relacionado com a tabela cateogoria no banco de dados h2. O primeiro parametros da classe
 * JpaRepository indica o objeto em questao e o segundo parametro indica o tipo do atributo identificador.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
