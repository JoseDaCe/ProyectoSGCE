package com.example.SistemaEnvio.repository;

import com.example.SistemaEnvio.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}
