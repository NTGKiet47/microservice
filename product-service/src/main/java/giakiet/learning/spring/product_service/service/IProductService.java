package giakiet.learning.spring.product_service.service;

import giakiet.learning.spring.product_service.dto.ProductDto;

import java.util.List;

public interface IProductService {
    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> getAll(java.lang.Integer pageNumber, java.lang.Integer pageSize);
}
