package com.example.SistemaEnvio.controller;

import com.example.SistemaEnvio.entity.Clientes;
import com.example.SistemaEnvio.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")


public class ClientesController {

    private final ClientesService clientesService;
    @Autowired
    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @GetMapping("/clientes")
    public List<Clientes> getAllClientes(){
        return clientesService.getAllClientes();
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Clientes> getClientesById(@PathVariable Long id){
        return clientesService.getClientesById(id);
    }
    @PostMapping("/clientes")
    public Clientes createClientes(@RequestBody Clientes clientes){
        return clientesService.saveClientes(clientes);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Clientes> putClientes(@PathVariable Long id, @RequestBody Clientes clientes){

        return clientesService.updateClientes(id,clientes);
    }

    @DeleteMapping("clientes/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteClientes(@PathVariable Long id){
        return clientesService.deleteClientes(id);
    }

}
