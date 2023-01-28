package rafael.ejercicio.Services;

import rafael.ejercicio.Models.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    public List<Product> getAll();

    public Product create(Product p);

    public Product update(Long id,Product p);

    public Map<String,Boolean> delete(Long id);

    public Product findById(Long id);
}
