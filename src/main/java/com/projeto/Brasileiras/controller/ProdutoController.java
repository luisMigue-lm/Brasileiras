package com.projeto.Brasileiras.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.projeto.Brasileiras.model.Produto;
import com.projeto.Brasileiras.repository.ProdutoRepository;
import com.projeto.Brasileiras.service.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produto/{id}")
    public String detalhesProdutoId(@PathVariable Long id, Model model) {
        Produto produto = produtoRepository.findById(id);
        model.addAttribute("produto", produto);

        return "produto";
    }

    @GetMapping("/cadastro-produto")
    public String cadastroCliente() {
        return "cadastro-produtos";
    }

    @PostMapping("/cadastrar-produto")
    public String cadastrarProduto(@RequestParam("foto") MultipartFile foto, @RequestParam String categoria,
            @RequestParam String nome, @RequestParam String descricao, @RequestParam String produtor,
            @RequestParam double preco, @RequestParam int quantd, @RequestParam LocalDate dtValidade) {

        try {
            Produto produto = new Produto();

            produto.setNome(nome);
            produto.setCategoria(categoria);
            produto.setDescricao(descricao);
            produto.setProdutor(produtor);
            produto.setPreco(preco);
            produto.setQuantidade(quantd);
            produto.setDtValidade(dtValidade);

            if (!foto.isEmpty()) {
                String caminhoSalvo = produtoService.salvarFoto(foto);
                produto.setCaminhoFoto(caminhoSalvo);
            }
            produtoRepository.save(produto);

            return "redirect:/lista-cruds";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    @GetMapping("/produto/editar/{id}")
    public String editarProduto(@PathVariable Long id, Model model) {
        Produto produto = produtoRepository.findById(id);
        model.addAttribute("produto", produto);

        return "atualizar-produto";
    }

    @PostMapping("/produto/atualizar/{id}")
    public String updateProduto(@PathVariable Long id, @RequestParam("foto") MultipartFile foto,
            @RequestParam String categoria,
            @RequestParam String nome, @RequestParam String descricao, @RequestParam String produtor,
            @RequestParam double preco, @RequestParam int quantd, @RequestParam LocalDate dtValidade) {
        try {
            Produto produto = produtoRepository.findById(id);

            produto.setNome(nome);
            produto.setCategoria(categoria);
            produto.setDescricao(descricao);
            produto.setProdutor(produtor);
            produto.setPreco(preco);
            produto.setQuantidade(quantd);
            produto.setDtValidade(dtValidade);

            if (!foto.isEmpty()) {
                String caminhoSalvo = produtoService.salvarFoto(foto);
                produto.setCaminhoFoto(caminhoSalvo);
            }
            produtoRepository.update(produto);
            ;

            return "redirect:/lista-cruds";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    @PostMapping("/produto/excluir/{id}")
    public String postMethodName(@PathVariable Long id) {
        produtoRepository.deleteById(id);

        return "redirect:/lista-cruds";
    }

    @GetMapping("/pesquisa")
    public String pesquisar(@RequestParam String nome, Model model) {
        List<Produto> produtos = produtoRepository.findByNome(nome);
        model.addAttribute("produtos", produtos);
        return "pesquisa";
    }

    @GetMapping("/pesquisa/{categoria}")
    public String produtosPorCategoria(@PathVariable String categoria, Model model) {

        List<Produto> produtos = produtoRepository.findByCategoria(categoria);
        model.addAttribute("produtos", produtos);
        model.addAttribute("categoria", categoria);

        return "pesquisa";
    }

}