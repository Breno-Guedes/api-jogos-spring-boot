package br.edu.ifpi.api_jogos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity 
@Table(name = "jogos")
public class Jogo {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String plataforma;
    private Double preco;
    private Boolean promocao;

    Jogo(){
    }
    
    public Jogo(String titulo, String plataforma, Double preco, Boolean promocao) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.preco = preco;
        this.promocao = promocao;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getPlataforma(){
        return plataforma;
    }
    public void setPlataforma(String plataforma){
        this.plataforma = plataforma;
    }

    public Double getPreco(){
        return preco;
    }
    public void setPreco(Double preco){
        this.preco = preco;
    }
    
    public Boolean getPromocao(){
        return promocao;
    }
    public void setPromocao(Boolean promocao){
        this.promocao = promocao;
    }

}
