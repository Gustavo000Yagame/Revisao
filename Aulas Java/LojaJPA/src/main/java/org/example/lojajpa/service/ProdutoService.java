package org.example.lojajpa.service;

import org.example.lojajpa.model.Produto;
import org.example.lojajpa.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository){
        this.repository = repository;
    }

    public Produto salvar(Produto produto){

    }

}
