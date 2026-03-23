package com._exercicios.demo.controllers;

import com._exercicios.demo.models.ClienteModel;
import com._exercicios.demo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ClienteModel criarCliente(@RequestBody ClienteModel clienteModel){
        return clienteService.criarCliente(clienteModel);
    }

    @GetMapping
    public List<ClienteModel> buscarTodosClientes(){return clienteService.buscarTodosClientes();}

    @GetMapping("/{id}")
    public ClienteModel buscarPorId(@PathVariable Long id){return clienteService.buscarPorId(id);}

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id){clienteService.deletarCliente(id);}
}
