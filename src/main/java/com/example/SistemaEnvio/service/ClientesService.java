package com.example.SistemaEnvio.service;


import com.example.SistemaEnvio.entity.Clientes;
import com.example.SistemaEnvio.repository.ClientesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {

    private ClientesRepository clientesRepository;

    public  ClientesService(ClientesRepository clientesRepository){
        this.clientesRepository=clientesRepository;
    }

    public List<Clientes> getAllClientes(){
        return clientesRepository.findAll();
    }

    public Optional<Clientes> getClientesById(Long id){
        return  clientesRepository.findById(id);
    }

    public Clientes saveClientes(Clientes clientes){
        return clientesRepository.save(clientes);

    }

    public void deleteClientes(Long id){
        clientesRepository.deleteById(id);
    }

}
