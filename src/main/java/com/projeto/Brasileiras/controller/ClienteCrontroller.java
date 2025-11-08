package com.projeto.Brasileiras.controller;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.projeto.Brasileiras.model.Cliente;
import com.projeto.Brasileiras.repository.ClienteRepository;
import com.projeto.Brasileiras.service.ClienteService;

@Controller
public class ClienteCrontroller {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente")
    public String pagCliente() {
        return "cliente";
    }

    @GetMapping("/cadastro-cliente")
    public String cadastro() {
        return "cadastro-cliente";
    }

    @PostMapping("/cadastrar-cliente")
    public String fazerlogin(@RequestParam String nome,
            @RequestParam String email, @RequestParam String telefone, @RequestParam String senha, @RequestParam String cpf) {
        try {
            Cliente cliente = new Cliente();

            cliente.setNome(nome);
            cliente.setEmail(email);
            cliente.setTelefone(telefone);
            cliente.setSenha(senha);
            cliente.setCpf(cpf);

            clienteRepository.save(cliente);

            return "redirect:/";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }

    }

    @PostMapping("/atualizar-cliente")
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

            clienteRepository.update(cliente);
            
            return "redirect:/";
        } catch (IOException e) {
            return "Erro: " + e.getMessage();
        }

    }

    @PostMapping("/excluir-cliente/{id}")
    public String excluirCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        
        return "redirect:/";
    }
    

}
