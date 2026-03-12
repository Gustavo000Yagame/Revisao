package org.example.lojajpa.repository;

import org.example.lojajpa.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long > {

}
