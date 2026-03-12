package org.example.lojajpa.service;

import org.example.lojajpa.model.Produto;
import org.example.lojajpa.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository){
        this.repository = repository;
    }

    public Produto salvar(Produto produto){
        return  repository.save(produto);
    }
    public Produto buscar(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Produto> listar(){
        return repository.findAll();
    }
}
