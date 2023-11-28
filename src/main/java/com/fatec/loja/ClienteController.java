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

import com.fatec.loja.entity.ClienteEntity;

@RestController
@CrossOrigin("*" )
public class ClienteController {
    @Autowired
    ClienteService service;
       
    @GetMapping("/api/cliente/{codigo}")
    public ResponseEntity<ClienteEntity> carregar(@PathVariable int codigo){        
        ClienteEntity obj = new ClienteEntity();
        Optional<ClienteEntity> retorno = service.carregar(codigo);
        if(retorno.isPresent()) obj =  retorno.get();        
        return ResponseEntity.ok(obj);
    }

    @PostMapping("/api/cliente")
    public ResponseEntity<String> gravar(@RequestBody ClienteEntity obj){        
        String msg = service.gravar(obj);
        return ResponseEntity.ok(msg); 
    }
    
    
    @PutMapping("/api/cliente")
    public ResponseEntity<String> atualizar(@RequestBody ClienteEntity obj){
        String msg = service.gravar(obj);
        return ResponseEntity.ok(msg); 
    }

    @DeleteMapping("/api/cliente/{codigo}")
    public ResponseEntity<String> remover(@PathVariable int codigo){
        String msg =service.remover(codigo);
        return ResponseEntity.ok(msg);
    }


    @GetMapping("/api/clientes")
    public ResponseEntity<List<ClienteEntity>> listar(){
        return ResponseEntity.ok(service.listar());
    }


    @PostMapping("/api/cliente/login")
    public ResponseEntity<ClienteEntity> fazerLogin(@RequestBody ClienteEntity dto){
        ClienteEntity obj = new ClienteEntity();
        Optional<ClienteEntity> retorno = service.fazerLogin(dto);
        if(retorno.isPresent()) obj =  retorno.get();        
        return ResponseEntity.ok(obj);
    }

}
