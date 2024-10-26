package br.edu.ifrs.restinga.mercadoseuze.controller;

import br.edu.ifrs.restinga.mercadoseuze.model.Product;
import br.edu.ifrs.restinga.mercadoseuze.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProductLeafController {

    @Autowired
    private ProductService produtoService;

    @GetMapping
    public String listarTodos(Model model) {
        List<Product> produtos = produtoService.listAll();
        model.addAttribute("produtos", produtos);
        return "products/list";
    }

    @GetMapping("/novo")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("produto", new Product());
        return "products/productform";
    }

    @PostMapping
    public String adicionarProduto(@ModelAttribute Product produto) {
        produtoService.persist(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/edit/{code}")
    public String exibirFormularioEdicao(@PathVariable Integer code, Model model) {
        Product produto = produtoService.findByCode(code);
        model.addAttribute("produto", produto);
        return "products/productform";
    }

    @GetMapping("/delete/{code}")
    public String removerProduto(@PathVariable Integer code) {
        produtoService.remover(code);
        return "redirect:/produtos";
    }
}