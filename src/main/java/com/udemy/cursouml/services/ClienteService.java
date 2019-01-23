package com.udemy.cursouml.services;

import com.udemy.cursouml.domain.Cliente;
import com.udemy.cursouml.repositories.ClienteRepository;
import com.udemy.cursouml.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository ClienteRepository;

    public Cliente buscar(Integer id) {
        Optional<Cliente> optionalCliente = ClienteRepository.findById(id);
        return optionalCliente.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + ", Tipo " +
                Cliente.class.getName()));
    }
}
