package com.udemy.cursouml.resources;

import com.udemy.cursouml.domain.Cliente;
import com.udemy.cursouml.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    /**
     * O objeto ResponseEntity ja retorna varias informacoes sobre o servico Rest, bem como sua resposta em caso
     * de sucesso ou em caso de falha.
     * @param id
     * @return
     */
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable("id") Integer id){
        Cliente obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }
}
