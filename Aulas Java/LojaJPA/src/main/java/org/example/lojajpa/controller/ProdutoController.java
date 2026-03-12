package org.example.lojajpa.controller;

import org.example.lojajpa.model.Produto;
import org.example.lojajpa.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service){
            this.service = service;

    }

        @GetMapping
        public List<Produto> Listar(){
            return service.listar();
        }

        @PostMapping
        public Produto criar(@RequestBody Produto produto){
            return service.salvar(produto);
        }

}
