package com.fatec.loja.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")   
public class ProdutoEntity {   
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long codigo;
        private String nome;
        private String descritivo;
        private String categoria;
        private double valor;
        private int quantidade;

        public long getCodigo() {
            return codigo;
        }
        public void setCodigo(long codigo) {
            this.codigo = codigo;
        }
        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public String getDescritivo() {
            return descritivo;
        }
        public void setDescritivo(String descritivo) {
            this.descritivo = descritivo;
        }
        public String getCategoria() {
            return categoria;
        }
        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }
        public double getValor() {
            return valor;
        }
        public void setValor(double valor) {
            this.valor = valor;
        }
        public int getQuantidade() {
            return quantidade;
        }
        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        } 
        
    
}