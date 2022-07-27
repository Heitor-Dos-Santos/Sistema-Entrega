package com.hector.logapi.service;

import com.hector.logapi.Repository.ClienteRepository;
import com.hector.logapi.exception.NegocioException;
import com.hector.logapi.model.Cliente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CatalogoClienteService {

    private ClienteRepository clienteRepository;

    public Cliente buscar (Long clienteId){
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NegocioException("Cliente nao encontrado"));
    }

    @Transactional
    public Cliente salvar(Cliente cliente){
       boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
       if (emailEmUso){
           throw new NegocioException("Já existe um cliente cadastrado com esse email.");
       }

        return clienteRepository.save(cliente);
    }

    public void excluir(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }

}
