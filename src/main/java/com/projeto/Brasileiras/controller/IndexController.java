package com.projeto.Brasileiras.controller;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.projeto.Brasileiras.model.Cliente;
import com.projeto.Brasileiras.repository.ClienteRepository;
import com.projeto.Brasileiras.service.ClienteService;

@Controller
public class IndexController {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cadastro-cliente")
    public String cadastro() {
        return "cadastro-cliente";
    }

    @PostMapping("/cadastrar-cliente")
    public String fazerlogin(@RequestParam("foto") MultipartFile foto, @RequestParam String nome,
            @RequestParam String email, @RequestParam String telefone,
            @RequestParam LocalDate dtNascimento, @RequestParam String senha, @RequestParam String cpf) {
        try {
            Cliente cliente = new Cliente();

            String caminhoSalvo = clienteService.salvarFoto(foto);
            cliente.setNome(nome);
            cliente.setEmail(email);
            cliente.setTelefone(telefone);
            cliente.setDtNascimento(dtNascimento);
            cliente.setSenha(senha);
            cliente.setCpf(cpf);
            cliente.setEnderecoFoto(caminhoSalvo);

            clienteRepository.save(cliente);

            return "redirect:/";
        } catch (IOException e) {
            return "Erro: " + e.getMessage();
        }

    }

    @GetMapping("/login-cliente")
    public String login() {
        return "login-cliente";
    }

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
}