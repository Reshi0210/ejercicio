package rafael.ejercicio.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rafael.ejercicio.Exeptions.ResourceNotFoundException;
import rafael.ejercicio.Models.Product;
import rafael.ejercicio.Repositories.ProductRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {

    ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product create(Product p) {
       return productRepository.save(p);

    }

    @Override
    public Product update(Long idOldProduct, Product newProduct) {
        Product oldProduct= productRepository.findById(idOldProduct)
                .orElseThrow(()->new ResourceNotFoundException("Resource_Not_Found"));
        newProduct.setIdProduct(oldProduct.getIdProduct());
        productRepository.save(newProduct);
        return newProduct;
    }

    @Override
    public Map<String,Boolean> delete(Long id) {
        Product p=findById(id);
        productRepository.delete(p);
        Map<String, Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
          return response;
    }

    @Override
    public Product findById(Long id) {
        return   productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource_Not_Found"));
    }





}
