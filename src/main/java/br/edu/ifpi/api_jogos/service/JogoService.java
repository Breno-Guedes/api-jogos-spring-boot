package br.edu.ifpi.api_jogos.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.*;

import br.edu.ifpi.api_jogos.repository.JogoRepository;
import br.edu.ifpi.api_jogos.models.*;

import java.util.ArrayList;
import java.util.List;

@Service 
public class JogoService {

    private final JogoRepository repository;

    JogoService(JogoRepository repository){
        this.repository = repository;
    }

    public Jogo cadastrar(Jogo jogos){
        return repository.save(jogos); 
    }
    
    public List<Jogo> listar(){
        return repository.findAll();
    }

    public Jogo buscarPorId(Long id){
        return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }

    public List<Jogo> buscarJogoPromocao(){
       List<Jogo> jogos = repository.findAll();
       List<Jogo> temp = new ArrayList<>();

       for(Jogo j : jogos){
         if(j.getPromocao().equals(true)){
            temp.add(j);
         }
       }

       return temp;
    }

    public Jogo atualizar(Long id, Jogo atualizado){
        Jogo j = buscarPorId(id);

        j.setTitulo(atualizado.getTitulo());
        j.setPlataforma(atualizado.getPlataforma());
        j.setPreco(atualizado.getPreco());
        j.setPromocao(atualizado.getPromocao());

        return repository.save(j);
    }

    public void apagar(Long id){
        Jogo existente = buscarPorId(id);

        repository.delete(existente);
    }
}
