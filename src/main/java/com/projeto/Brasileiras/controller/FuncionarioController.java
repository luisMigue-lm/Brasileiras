package com.projeto.Brasileiras.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projeto.Brasileiras.model.Funcionario;
import com.projeto.Brasileiras.repository.FuncionarioRepository;
import com.projeto.Brasileiras.service.FuncionarioService;

@Controller
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/funcionario")
    public String funcionario() {
        return "funcionario";
    }

    @GetMapping("/cadastro-funcionario")
    public String cadastroFuncionario() {
        return "cadastro-funcionario";
    }

    @PostMapping("/cadastrar-funcionario")
    public String cadastrarFuncionario(@RequestParam String nome,
            @RequestParam String email, @RequestParam String telefone, @RequestParam String senha,
            @RequestParam String cpf, @RequestParam LocalDate dtNascimento, @RequestParam String cargo,
            @RequestParam String departamento) {
                try {
                    Funcionario funcionario = new Funcionario();

                    funcionario.setNome(nome);
                    funcionario.setEmail(email);
                    funcionario.setTelefone(telefone);
                    funcionario.setSenha(senha);
                    funcionario.setCpf(cpf);
                    funcionario.setDtNascimento(dtNascimento);
                    funcionario.setCargo(cargo);
                    funcionario.setDepartamento(departamento);

                    if (funcionario.getCargo().equals("administrador")) {
                        funcionario.setSalario(5500);                        
                    } else {
                        funcionario.setSalario(2300);
                    }

                    funcionarioRepository.save(funcionario);
                    
                    return "redirect:/";
                } catch (Exception e) {
                    return "Erro: " + e.getMessage();
                }
    }

    @PostMapping("/excluir-funcionario/{id}")
    public String excluirCliente(@PathVariable Long id) {
        funcionarioRepository.deleteById(id);
        
        return "redirect:/";
    }

}
