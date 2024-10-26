package br.edu.ifrs.restinga.mercadoseuze.repository;

import br.edu.ifrs.restinga.mercadoseuze.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Definir consultas customizadas se necessário
    Product findByName(String name);
    void deleteById(Integer code);

    Product findByCode(Integer code);
    Product deleteByCode(Integer code);

}