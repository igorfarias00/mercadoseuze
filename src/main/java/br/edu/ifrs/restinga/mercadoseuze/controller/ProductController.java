package br.edu.ifrs.restinga.mercadoseuze.controller;

import br.edu.ifrs.restinga.mercadoseuze.model.Product;
import br.edu.ifrs.restinga.mercadoseuze.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> list() {
        return productService.listAll();
    }

    @PostMapping
    public Product newProduct(@RequestBody Product product) {
        return productService.persist(product);
    }

    @GetMapping("/{name}")
    public Product searchByName(@PathVariable String name) {
        return productService.searchByName(name);
    }
}