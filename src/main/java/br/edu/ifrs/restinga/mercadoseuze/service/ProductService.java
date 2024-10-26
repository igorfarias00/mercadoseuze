package br.edu.ifrs.restinga.mercadoseuze.service;

import br.edu.ifrs.restinga.mercadoseuze.model.Product;
import br.edu.ifrs.restinga.mercadoseuze.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Product persist(Product produto) {
        return productRepository.save(produto);
    }

    public Product searchByName(String nome) {
        return productRepository.findByName(nome);
    }

    public Product findByCode(Integer code) {
        Optional<Product> produtoOptional = Optional.ofNullable(productRepository.findByCode(code));
        return produtoOptional.orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public void remover(Integer code) {
        productRepository.deleteById(code);
    }

}