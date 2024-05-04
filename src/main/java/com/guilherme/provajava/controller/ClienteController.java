package com.guilherme.provajava.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme.provajava.model.dto.ClienteDTO;
import com.guilherme.provajava.model.entity.Cliente;
import com.guilherme.provajava.model.entity.Endereco;
import com.guilherme.provajava.service.ClientService;



@RestController
@RequestMapping
public class ClienteController {
    
    private ClientService clienteService;
    public ClienteController(ClientService clienteService) {
        this.clienteService = clienteService;
    }
    
    @GetMapping
    public ResponseEntity<?> hello() {
        return new ResponseEntity<String>("Hello world",HttpStatusCode.valueOf(200));
    }

    
    @GetMapping({"/{id}","/"})
    public ResponseEntity<?> buscarCliente(@PathVariable(required = false) Long id) {
        if (id == null) {
            List<Cliente> clientes = clienteService.buscarClientes();
            return new ResponseEntity<>(clientes,HttpStatusCode.valueOf(200));
        }

        Cliente cliente = clienteService.buscarCliente(id);
        if (cliente != null) {
            return new ResponseEntity<>(cliente,HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(204));
    }

    @PostMapping
    public ResponseEntity<?> salvarCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cli = clienteService.salvarCliente(clienteDTO);
        return new ResponseEntity<>(cli,HttpStatusCode.valueOf(200));
    }


    @GetMapping("/x")
    public ResponseEntity<?> buscarClientexx() {
        Endereco end = clienteService.buscarEndereco();
        if (end != null) {
            return new ResponseEntity<>(end,HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(204));
    }
}
