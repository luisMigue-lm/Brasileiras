package com.projeto.Brasileiras.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.projeto.Brasileiras.model.Produto;
import com.projeto.Brasileiras.repository.ProdutoRepository;

@Controller
public class IndexController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/listar-produtos")
    public String listarProdutos(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);

        return "index";
    }

    @GetMapping("/produto/{id}")
    public String detalhesProdutoId(@PathVariable Long id, Model model) {
        Produto produto = produtoRepository.findById(id);
        model.addAttribute("produto", produto);

        return "produto-detalhes";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /* 
    @PostMapping("/logar-cliente")
    public String fazerlogin(@RequestParam String email, @RequestParam String senha, Model model) {

        Cliente cliente = new Cliente();
        cliente.getEmail();
        cliente.getSenha();

        if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
            return "redirect:/brasileras";
        } else {
            model.addAttribute("erro", "Email ou senha inválidos!");
            return "login-cliente";
        }
    }
        */
}