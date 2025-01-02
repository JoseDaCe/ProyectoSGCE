package com.example.SistemaEnvio.controller;

import com.example.SistemaEnvio.entity.Clientes;
import com.example.SistemaEnvio.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")

public class ClientesController {

    private final ClientesService clientesService;
    @Autowired
    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @GetMapping
    public List<Clientes> getAllClientes(){
        return clientesService.getAllClientes();
    }

    @GetMapping("/{id}")
    public Optional<Clientes> getClientesById(@PathVariable Long id){
        return clientesService.getClientesById(id);
    }
    @PostMapping
    public Clientes createClientes(@RequestBody Clientes clientes){
        return clientesService.saveClientes(clientes);
    }

    @PutMapping("/{id}")
    public Clientes updateClientes(@PathVariable Long id, @RequestBody Clientes clientes){
        clientes.setId(id);
        return clientesService.saveClientes(clientes);
    }

    @DeleteMapping("/{id}")
    public void deleteClientes(@PathVariable Long id){
        clientesService.deleteClientes(id);
    }

}
