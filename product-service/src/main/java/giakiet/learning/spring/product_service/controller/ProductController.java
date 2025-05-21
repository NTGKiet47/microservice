package giakiet.learning.spring.product_service.controller;

import giakiet.learning.spring.product_service.constant.ApiConstant;
import giakiet.learning.spring.product_service.dto.ProductDto;
import giakiet.learning.spring.product_service.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstant.API_PRODUCT)
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> getAllProducts(
            @RequestParam(required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(required = false, defaultValue = "20") Integer pageSize
    ){
        return productService.getAll(pageNumber, pageSize);
    }

}
