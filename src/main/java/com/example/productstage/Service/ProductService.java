package com.example.productstage.Service;

import com.example.productstage.Collections.Product;
import com.example.productstage.DTOs.ProductDTO;
import com.example.productstage.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setUnitPrice(productDTO.getUnitPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setDescription(productDTO.getDescription());

        product = productRepository.save(product);
        return entityToDto(product);
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(String id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.map(this::entityToDto).orElse(null);
    }

    public ProductDTO updateProduct(String id, ProductDTO productDTO) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(productDTO.getName());
            product.setUnitPrice(productDTO.getUnitPrice());
            product.setQuantity(productDTO.getQuantity());
            product.setDescription(productDTO.getDescription());

            product = productRepository.save(product);
            return entityToDto(product);
        }
        return null;
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
    public List<ProductDTO> searchProducts(String keyword) {
        List<Product> products = productRepository.findAll();

        // Perform the search based on the provided keyword.
        List<ProductDTO> searchResults = products.stream()
                .filter(product -> product.getName().toLowerCase().contains(keyword.toLowerCase()))
                .map(this::entityToDto)
                .collect(Collectors.toList());

        return searchResults;
    }

    private ProductDTO entityToDto(Product entity) {
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setUnitPrice(entity.getUnitPrice());
        dto.setQuantity(entity.getQuantity());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}
