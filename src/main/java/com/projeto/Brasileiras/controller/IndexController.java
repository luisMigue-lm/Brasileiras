package com.projeto.Brasileiras.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projeto.Brasileiras.model.Cliente;

@Controller
public class IndexController {

    @Autowired
    private ClienteRepository brasileirasRepository;

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro.html";
    }

    @PostMapping("/fazerCadastro")
    public String fazerlogin(@RequestParam String nome, @RequestParam String email, @RequestParam String telefone,
            @RequestParam LocalDate dtNascimento, @RequestParam String senha, @RequestParam String cpf) {

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setDtNascimento(dtNascimento);
        cliente.setSenha(senha);
        cliente.setCpf(cpf);

        brasileirasRepository.save(cliente);

        return "redirect:/brasileras";
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @PostMapping("/fazerLogin")
    public String fazerlogin(@RequestParam String email, @RequestParam String senha, Model model) {

        Cliente cliente = new Cliente();
        cliente.getEmail();
        cliente.getSenha();

        if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
            return "redirect:/brasileras";
        } else {
            model.addAttribute("erro", "Email ou senha inválidos!");
            return "login.html";
        }
    }
}