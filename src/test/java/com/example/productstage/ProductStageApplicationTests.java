package com.example.productstage;

import com.example.productstage.DTOs.ProductDTO;
import com.example.productstage.Service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertNotEquals; // Import the correct assertion method
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductStageApplicationTests {

    @Autowired
    private ProductService productService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void GetAllProducts() {
        int result = productService.getAllProducts().size();
        assertNotEquals(0 , result); // Replace assert with assertEquals
    }
    @Test
    void CreateProduct() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Ahmed");
        productDTO.setUnitPrice(12.50);
        productDTO.setQuantity(5);
        String requestJson = objectMapper.writeValueAsString(productDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/products/createProduct")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isCreated()); // Assert that the status code is 201
    }

}
