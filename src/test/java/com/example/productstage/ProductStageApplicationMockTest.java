package com.example.productstage;

import com.example.productstage.Collections.Product;
import com.example.productstage.DTOs.ProductDTO;
import com.example.productstage.Repository.ProductRepository;
import com.example.productstage.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductStageApplicationMockTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    void testFindById() {
        Optional<Product> productParam = Optional.of(new Product("14", "", "", 2.35, 2));
        Mockito.when(productRepository.findById(Mockito.anyString())).thenReturn(productParam);
        ProductDTO product = productService.getProductById("14");
        assertNotNull(product);
    }
}
