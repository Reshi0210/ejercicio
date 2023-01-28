package rafael.ejercicio.Services;

import rafael.ejercicio.DTOs.ProductDto;
import rafael.ejercicio.Models.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    public List<ProductDto> getAll();

    public ProductDto create(ProductDto p);

    public ProductDto update(Long id,ProductDto p);

    public Map<String,Boolean> delete(Long id);

    public ProductDto findById(Long id);
}
