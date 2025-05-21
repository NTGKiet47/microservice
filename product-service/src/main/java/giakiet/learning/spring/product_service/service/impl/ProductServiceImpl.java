package giakiet.learning.spring.product_service.service.impl;

import giakiet.learning.spring.product_service.dto.ProductDto;
import giakiet.learning.spring.product_service.entity.Product;
import giakiet.learning.spring.product_service.repository.ProductRepository;
import giakiet.learning.spring.product_service.service.IProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        try {
            Product product = productRepository.save(Product.builder()
                    .name(productDto.getName())
                    .description(productDto.getDescription())
                    .price(productDto.getPrice())
                    .build());

            log.info("ProductServiceImpl | createProduct | Success | Create product successfully");
            return toProductRequestDto(product);
        } catch (Exception e) {
            log.error("ProductServiceImpl | createProduct | Error | {}", e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<ProductDto> getAll(Integer pageNumber, Integer pageSize) {
        try{
            log.info("ProductServiceImpl | getAll | Success | Get all products successfully");
            return productRepository.findAll().stream().map(
                    this::toProductRequestDto).toList();
        }catch (Exception e){
            log.error("ProductServiceImpl | getAll | Error | {}", e.getMessage(), e);
        }
        return null;
    }

    private ProductDto toProductRequestDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
