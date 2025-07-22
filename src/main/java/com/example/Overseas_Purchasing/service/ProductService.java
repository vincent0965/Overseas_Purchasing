package com.example.Overseas_Purchasing.service;

import com.example.Overseas_Purchasing.dto.ProductRequestDTO;
import com.example.Overseas_Purchasing.dto.ProductResponseDTO;
import com.example.Overseas_Purchasing.model.Product;
import com.example.Overseas_Purchasing.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponseDTO createProduct(ProductRequestDTO request) {
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .stock(request.getStock())
                .build();

        Product saved = productRepository.save(product);
        return mapToResponseDTO(saved);
    }

    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProductResponseDTO> getProductById(Long id) {
        return productRepository.findById(id)
                .map(this::mapToResponseDTO);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    private ProductResponseDTO mapToResponseDTO(Product product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .createdDate(product.getCreatedDate())
                .build();
    }
}
