package br.edu.ifpi.api_jogos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

import br.edu.ifpi.api_jogos.service.JogoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import br.edu.ifpi.api_jogos.models.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import org.springframework.web.bind.annotation.PutMapping;

@RestController 
@RequestMapping("/jogos")
public class JogoController {
    
    private final JogoService service;

    JogoController(JogoService service){
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jogo cadastrar(@RequestBody Jogo jogos) {
       return service.cadastrar(jogos);
    }

    @GetMapping()
    public List<Jogo> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Jogo buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/promocao")
    public List<Jogo> buscarJogoPromocao() {
        return service.buscarJogoPromocao();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Jogo atualizar(@PathVariable Long id, @RequestBody Jogo atualizado) {
        return service.atualizar(id, atualizado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void apagar(@PathVariable Long id){
        service.apagar(id);
    }
}
