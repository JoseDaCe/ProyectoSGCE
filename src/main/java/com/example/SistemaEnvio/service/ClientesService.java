package com.example.SistemaEnvio.service;


import com.example.SistemaEnvio.entity.Clientes;
import com.example.SistemaEnvio.exception.ResourceNotFoundException;
import com.example.SistemaEnvio.repository.ClientesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public ResponseEntity<Clientes> getClientesById(Long id){
         Clientes clientes = clientesRepository.findById(id)
                 .orElseThrow(() ->new ResourceNotFoundException("el cliente no existe con ese id: " + id));
    return  ResponseEntity.ok(clientes);

    }

    public Clientes saveClientes(Clientes clientes){
        return clientesRepository.save(clientes);

    }

    public ResponseEntity<Clientes> updateClientes(Long id, @RequestBody Clientes clientes){
        Clientes cliente = clientesRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("El Cliente no existe con ese id: "+id));

        cliente.setIdentificacion(cliente.getIdentificacion());
        cliente.setNombres(clientes.getNombres());
        cliente.setApellidos(clientes.getApellidos());
        cliente.setDireccion(clientes.getDireccion());
        cliente.setTelefono(clientes.getTelefono());
        cliente.setEmail(clientes.getEmail());

        Clientes clienteActualizado =clientesRepository.save(cliente);
        return ResponseEntity.ok(clienteActualizado);
    }

    public ResponseEntity<Map<String,Boolean>> deleteClientes(Long id){
        if (!clientesRepository.existsById(id)) {
             throw new ResourceNotFoundException("Cliente no existe!");
        }
        clientesRepository.deleteById(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Eliminado con exito",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
