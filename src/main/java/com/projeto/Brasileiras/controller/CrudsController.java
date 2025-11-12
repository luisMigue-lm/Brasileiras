package com.projeto.Brasileiras.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.projeto.Brasileiras.model.Cliente;
import com.projeto.Brasileiras.model.Funcionario;
import com.projeto.Brasileiras.model.Produto;
import com.projeto.Brasileiras.repository.ClienteRepository;
import com.projeto.Brasileiras.repository.FuncionarioRepository;
import com.projeto.Brasileiras.repository.ProdutoRepository;



@Controller
public class CrudsController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping("/lista-cruds")
    public String listaCruds(Model model) {
        List<Cliente> clientes = clienteRepository.findAll();
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        List<Produto> produtos = produtoRepository.findAll();

        model.addAttribute("clientes", clientes);
        model.addAttribute("funcionarios", funcionarios);
        model.addAttribute("produtos", produtos);

        return "lista-cruds";
    }


    
}
