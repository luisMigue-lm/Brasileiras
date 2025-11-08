package com.projeto.Brasileiras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.projeto.Brasileiras.repository.ProdutoRepository;
import com.projeto.Brasileiras.service.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produto")
    public String produto() {
        return "produto";
    }
    

}
