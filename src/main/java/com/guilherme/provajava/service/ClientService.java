package com.guilherme.provajava.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.guilherme.provajava.model.dto.ClienteDTO;
import com.guilherme.provajava.model.entity.Cliente;
import com.guilherme.provajava.model.entity.Endereco;
import com.guilherme.provajava.repository.ClienteRepository;
import com.guilherme.provajava.repository.EnderecoRepository;

import jakarta.validation.Valid;

@Service
public class ClientService {

    private ClienteRepository clienteRepository;
    private EnderecoRepository enderecoRepository;

    public ClientService(ClienteRepository clienteRepository,EnderecoRepository enderecoRepository) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
    }


    public Cliente salvarCliente(@Valid ClienteDTO dto) {
        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        
        cliente.setNome(dto.nome());
        cliente.setCnpj(dto.cnpj());
        
        endereco.setCep(dto.endereco().cep());
        endereco.setCidade(dto.endereco().cidade());
        endereco.setEstado(dto.endereco().estado());
        endereco.setLogradouro(dto.endereco().logradouro());
        endereco.setLatitude(dto.endereco().latitude());
        endereco.setLongitude(dto.endereco().longitude());
        
        Cliente res = null;
        try {
            res = clienteRepository.save(cliente);
            if( res.getId() > 0 ) {
                endereco.setCliente(res);
                enderecoRepository.save(endereco);
            }
        }
        catch (Exception e) { System.err.println(e.getLocalizedMessage());}
        return res;
    }


    public List<Cliente> buscarClientes() {
        return clienteRepository.findAll();
    }


    public Cliente buscarCliente(long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Endereco buscarEndereco() {
        return enderecoRepository.findById((long) 1).orElse(null);
    }

}

