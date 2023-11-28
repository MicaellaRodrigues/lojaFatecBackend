package com.fatec.loja;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import com.fatec.loja.entity.ProdutoEntity;

@RestController
@CrossOrigin( origins = "*" )
public class ProdutoController {
    @Autowired
    private ProdutoService service;
 
    @GetMapping("/api/produto/{codigo}")
    public ResponseEntity<ProdutoEntity> carregar(@PathVariable long codigo){
        ProdutoEntity obj = new ProdutoEntity();
        Optional<ProdutoEntity> retorno = service.carregar(codigo);
        if(retorno.isPresent()) obj =  retorno.get();        
        return ResponseEntity.ok(obj);
    }

    @PostMapping("/api/produto")
    public ResponseEntity<String> gravar(@RequestBody ProdutoEntity obj){
        service.gravar(obj);
        String msg = "Registro gravado com sucesso!";
        return ResponseEntity.ok(msg); 
    }
    
    @PutMapping("/api/produto")
    public ResponseEntity<String> atualizar(@RequestBody ProdutoEntity obj){
        service.gravar(obj);
        String msg = "Registro alterado com sucesso !";
        return ResponseEntity.ok(msg); 
    }

    @DeleteMapping("/api/produto/{codigo}")
    public ResponseEntity<String> remover(@PathVariable int codigo){
        ProdutoEntity obj = new ProdutoEntity();
        obj.setCodigo(codigo);   
        String msg = "Registro removido com sucesso !";
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/api/produtos")
    public ResponseEntity<List<ProdutoEntity>> listar(){
        return ResponseEntity.ok(service.listar());
    }
}
