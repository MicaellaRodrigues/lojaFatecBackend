package com.fatec.loja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fatec.loja.repository.PedidoRepository;
import com.fatec.loja.entity.PedidoEntity;
import java.util.Optional;
import java.util.List;

@Service
public class CestaService {
    @Autowired
    private CestaRepository repository;    

    public void gravar(CestaEntity obj){
        repository.save(obj);
    }

    public void remover(CestaEntity obj){
        repository.delete(obj);
    }
    
    public Optional<CestaEntity> carregar(long codigo){
        return repository.findById(codigo);        
    }

    public List<CestaEntity> listar(){
        return repository.findAll();
    }


}