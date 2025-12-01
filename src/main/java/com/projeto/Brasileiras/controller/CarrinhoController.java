package com.projeto.Brasileiras.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.projeto.Brasileiras.model.Carrinho;
import com.projeto.Brasileiras.model.Produto;
import com.projeto.Brasileiras.repository.ProdutoRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class CarrinhoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/carrinho/adicionar/{id}")
    public String adicionarAoCarrinho(@PathVariable Long id, HttpSession session) {

        Produto produto = produtoRepository.findById(id);

        if (produto == null) {
            return "redirect:/";
        }

        List<Carrinho> carrinho = (List<Carrinho>) session.getAttribute("carrinho");

        if (carrinho == null) {
            carrinho = new ArrayList<>();
        }

        for (Carrinho item : carrinho) {
            if (item.getProduto().getId().equals(id)) {
                item.setQuantidade(item.getQuantidade() + 1);
                session.setAttribute("carrinho", carrinho);
                return "redirect:/carrinho";
            }
        }

        carrinho.add(new Carrinho(1, produto));

        session.setAttribute("carrinho", carrinho);
        return "redirect:/carrinho";
    }

    @GetMapping("/carrinho")
    public String carrinho(Model model, HttpSession session) {
        List<Carrinho> carrinho = (List<Carrinho>) session.getAttribute("carrinho");

        if (carrinho == null) {
            carrinho = new ArrayList<>();
        }

        double total = 0;
        for (Carrinho item : carrinho) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }

        model.addAttribute("carrinho", carrinho);
        model.addAttribute("total", total);

        return "carrinho";
    }

    @GetMapping("/carrinho/diminuir/{id}")
    public String diminuir(@PathVariable Long id, HttpSession session) {

        List<Carrinho> carrinho = (List<Carrinho>) session.getAttribute("carrinho");

        for (Carrinho item : carrinho) {
            if (item.getProduto().getId().equals(id)) {

                if (item.getQuantidade() > 1) {
                    item.setQuantidade(item.getQuantidade() - 1);
                } else {
                    carrinho.remove(item);
                }

                return "redirect:/carrinho";
            }
        }

        return "redirect:/carrinho";
    }

    @GetMapping("/carrinho/aumentar/{id}")
    public String aumentar(@PathVariable Long id, HttpSession session) {

        List<Carrinho> carrinho = (List<Carrinho>) session.getAttribute("carrinho");

        if (carrinho != null) {
            for (Carrinho item : carrinho) {
                if (item.getProduto().getId().equals(id)) {

                    Produto produto = produtoRepository.findById(id);

                    if (item.getQuantidade() < produto.getQuantidade()) {
                        item.setQuantidade(item.getQuantidade() + 1);
                    }

                    break;
                }
            }
        }

        session.setAttribute("carrinho", carrinho);
        return "redirect:/carrinho";
    }

    @GetMapping("/carrinho/remove/{id}")
    public String Removerproduto(@PathVariable Long id, HttpSession session) {
        List<Carrinho> carrinho = (List<Carrinho>) session.getAttribute("carrinho");

        if (carrinho != null) {
            carrinho.removeIf(item -> item.getProduto().getId().equals(id));
        }
        session.setAttribute("carrinho", carrinho);
        return "redirect:/carrinho";
    }
}
