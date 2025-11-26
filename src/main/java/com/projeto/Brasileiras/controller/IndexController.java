package com.projeto.Brasileiras.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projeto.Brasileiras.model.Cliente;
import com.projeto.Brasileiras.model.Produto;
import com.projeto.Brasileiras.repository.ClienteRepository;
import com.projeto.Brasileiras.repository.ProdutoRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/")
    public String listarProdutos(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);

        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/cliente-login")
    public String fazerlogin(@RequestParam String email, @RequestParam String senha, Model model, HttpSession session) {

        Cliente cliente = clienteRepository.buscarPorEmailESenha(email, senha);

        if (cliente == null) {
            model.addAttribute("erro", "Email ou senha inválidos!");
            return "login";
        }

        session.setAttribute("clienteLogado", cliente);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}