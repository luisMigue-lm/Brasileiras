package com.projeto.Brasileiras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projeto.Brasileiras.model.Cliente;
import com.projeto.Brasileiras.model.Endereco;
import com.projeto.Brasileiras.repository.ClienteRepository;
import com.projeto.Brasileiras.repository.EnderecoRepository;
import com.projeto.Brasileiras.repository.FuncionarioRepository;
import com.projeto.Brasileiras.model.Funcionario;

@Controller
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // Página do formulário
    @GetMapping("/cadastro-endereco")
    public String cadastroEndereco(@RequestParam(required = false) Long clienteId,
            @RequestParam(required = false) Long funcionarioId,
            Model model) {

        Endereco endereco = new Endereco();
        model.addAttribute("endereco", endereco);
        model.addAttribute("clienteId", clienteId);
        model.addAttribute("funcionarioId", funcionarioId);

        return "endereco";
    }

    // Salvar endereço
    @PostMapping("/cadastrar-endereco")
    public String cadastrarEndereco(Endereco endereco, @RequestParam(required = false) Long clienteId,
            @RequestParam(required = false) Long funcionarioId) {

        if (clienteId != null) {
            Cliente cliente = clienteRepository.findById(clienteId);
            endereco.setCliente(cliente);
        }

        if (funcionarioId != null) {
            Funcionario funcionario = funcionarioRepository.findById(funcionarioId);
            endereco.setFuncionario(funcionario);
        }

        enderecoRepository.save(endereco);

        return "redirect:/";
    }

    // Editar endereço
    @GetMapping("/endereco/editar/{id}")
    public String editarEndereco(@PathVariable Long id, Model model) {
        Endereco endereco = enderecoRepository.findById(id);
        model.addAttribute("endereco", endereco);

        return "editar-endereco";
    }

    // Atualizar endereço
    @PostMapping("/endereco/atualizar/{id}")
    public String atualizarEndereco(@PathVariable Long id,
            @RequestParam String cep,
            @RequestParam String rua,
            @RequestParam int numResidencial,
            @RequestParam String complemento,
            @RequestParam String bairro,
            @RequestParam String cidade,
            @RequestParam String estado) {

        Endereco endereco = enderecoRepository.findById(id);

        endereco.setCep(cep);
        endereco.setRua(rua);
        endereco.setNumResidencial(numResidencial);
        endereco.setComplemento(complemento);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);

        enderecoRepository.update(endereco);

        return "redirect:/";
    }

    // Excluir endereço
    @PostMapping("/endereco/excluir/{id}")
    public String excluirEndereco(@PathVariable Long id) {
        enderecoRepository.deleteById(id);
        return "redirect:/";
    }
}
