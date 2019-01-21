package com.udemy.cursouml.services;

import com.udemy.cursouml.domain.Categoria;
import com.udemy.cursouml.repositories.CategoriaRepository;
import com.udemy.cursouml.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscar(Integer id) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
        return optionalCategoria.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + ", Tipo " +
                Categoria.class.getName()));
    }
}
