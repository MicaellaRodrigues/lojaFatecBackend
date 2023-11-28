package com.fatec.loja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.loja.entity.ClienteEntity;
import com.fatec.loja.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
     
     public String gravar(ClienteEntity dto){
        repository.save(dto);
        return "tudo certo";
     }

     public Optional<ClienteEntity> carregar(int codigo){        
        return repository.findById(codigo);        
     }

    public String remover(int codigo) {
        ClienteEntity obj = new ClienteEntity();
        obj.setCodigo(codigo);
        repository.delete(obj);
        return "tudo certo";
    }

    public List<ClienteEntity> listar() {
        return  repository.findAll();
    }

    public Optional<ClienteEntity> fazerLogin(ClienteEntity obj){        
        return repository.fazerLogin(obj.getEmail(), obj.getSenha());        
    }

}
