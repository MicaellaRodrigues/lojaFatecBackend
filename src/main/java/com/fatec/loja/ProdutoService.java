package com.fatec.loja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fatec.loja.repository.ProdutoRepository;
import com.fatec.loja.entity.ProdutoEntity;
import java.util.Optional;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;    

    public void gravar(ProdutoEntity obj){
        repository.save(obj);
    }

    public void remover(ProdutoEntity obj){
        repository.delete(obj);
    }
    
    public Optional<ProdutoEntity> carregar(long codigo){
        return repository.findById(codigo);        
    }

    public List<ProdutoEntity> listar(){
        return repository.findAll();
    }


}
