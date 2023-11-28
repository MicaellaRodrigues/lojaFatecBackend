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
import com.fatec.loja.entity.PedidoEntity;

@RestController
@CrossOrigin( origins = "*" )
public class PedidoController {
    @Autowired
    private PedidoService service;
 
    @GetMapping("/api/pedido/{codigo}")
    public ResponseEntity<PedidoEntity> carregar(@PathVariable long codigo){
        PedidoEntity obj = new PedidoEntity();
        Optional<PedidoEntity> retorno = service.carregar(codigo);
        if(retorno.isPresent()) obj =  retorno.get();        
        return ResponseEntity.ok(obj);
    }

    @PostMapping("/api/pedido")
    public ResponseEntity<String> gravar(@RequestBody PedidoEntity obj){
        service.gravar(obj);
        String msg = "Pedido realizado com sucesso!";
        return ResponseEntity.ok(msg); 
    }
    
    @PutMapping("/api/pedido")
    public ResponseEntity<String> atualizar(@RequestBody PedidoEntity obj){
        service.gravar(obj);
        String msg = "Pedido alterado com sucesso!";
        return ResponseEntity.ok(msg); 
    }

    @DeleteMapping("/api/pedido/{codigo}")
    public ResponseEntity<String> remover(@PathVariable int codigo){
        PedidoEntity obj = new PedidoEntity();
        obj.setCodigo(codigo);   
        String msg = "Pedido removido com sucesso !";
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/api/pedido")
    public ResponseEntity<List<PedidoEntity>> listar(){
        return ResponseEntity.ok(service.listar());
    }
}
