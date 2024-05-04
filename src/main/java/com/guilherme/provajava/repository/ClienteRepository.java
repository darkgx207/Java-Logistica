package com.guilherme.provajava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.provajava.model.entity.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    
}
