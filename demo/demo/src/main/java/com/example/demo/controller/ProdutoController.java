package com.example.demo.controller;


import com.example.demo.model.Produto;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/produtos")

public class ProdutoController {

    private ArrayList<Produto> produtos = new ArrayList<>();


    public ProdutoController() {
        produtos.add(new Produto(1L, "Notebook", 4500.0));
        produtos.add(new Produto(2L, "PS2", 500.00));
        produtos.add(new Produto(3L, "Mouse", 100.00));

    }

    @GetMapping
    public ArrayList<Produto> listarProdutos() {
        return produtos;
    }

    @GetMapping("/{id}")
    public Produto listarObjeto(@PathVariable Long id) {

        for (Produto p : produtos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    @PostMapping
    public Produto adionar(@RequestBody Produto produto) {
        produtos.add(produto);
        return produto;
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        for (Produto p : produtos) {
            if (p.getId().equals(id)) {
                p.setNome(produtoAtualizado.getNome());
                p.setPreco(produtoAtualizado.getPreco());
                return p;
            }
        }
        return null;
    }

    @DeleteMapping
    public String remover(@PathVariable Long id) {
        produtos.removeIf(p -> p.getId().equals(id));
        return "Produto removido da lista";
    }

}