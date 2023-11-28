package com.fatec.loja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fatec.loja.repository.PedidoRepository;
import com.fatec.loja.entity.PedidoEntity;
import java.util.Optional;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;    

    public void gravar(PedidoEntity obj){
        repository.save(obj);
    }

    public void remover(PedidoEntity obj){
        repository.delete(obj);
    }
    
    public Optional<PedidoEntity> carregar(long codigo){
        return repository.findById(codigo);        
    }

    public List<PedidoEntity> listar(){
        return repository.findAll();
    }


}