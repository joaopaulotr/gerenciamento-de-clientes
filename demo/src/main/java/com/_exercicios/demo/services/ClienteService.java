package com._exercicios.demo.services;

import com._exercicios.demo.models.ClienteModel;
import com._exercicios.demo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteModel criarCliente(ClienteModel clienteModel){return clienteRepository.save(clienteModel);}

    public List<ClienteModel> buscarTodosClientes(){return clienteRepository.findAll();}

    public ClienteModel buscarPorId(Long idInformado){
        java.util.Optional<ClienteModel> clienteOptional = clienteRepository.findById(idInformado);
        if(clienteOptional.isPresent()){
            return clienteOptional.get();
        }else {
            throw new RuntimeException("Clieente não encontrado com o ID:" + idInformado);
        }
    }
    public void deletarCliente(Long id){clienteRepository.deleteById(id);}
}
