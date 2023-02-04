package rafael.ejercicio.Services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import rafael.ejercicio.DTOs.ProductDto;
import rafael.ejercicio.Exeptions.ResourceNotFoundException;
import rafael.ejercicio.Models.Product;
import rafael.ejercicio.Repositories.ProductRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {

    ProductRepository productRepository;
    ModelMapper modelMapper;

    @Override
    public List<ProductDto> getAll() {
        return productRepository.findAll()
                .stream().map(product -> {
                    return modelMapper.map(product,ProductDto.class); })
                           .collect(Collectors.toList());
    }

    @Override
    public ProductDto create(ProductDto p) {
        productRepository.save(modelMapper.map(p,Product.class));
       return p;

    }

    @Override
    public ProductDto update(Long idOldProduct, ProductDto newProduct) {
        Product oldProduct= productRepository.findById(idOldProduct)
                .orElseThrow(()->new ResourceNotFoundException("Resource_Not_Found"));
        newProduct.setIdProduct(oldProduct.getIdProduct());
        productRepository.save(modelMapper.map(newProduct,Product.class));
        return newProduct;
    }

    @Override
    public Map<String,Boolean> delete(Long id) {
        Product p=productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource_Not_Found"));
        productRepository.delete(p);
        Map<String, Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
          return response;
    }

    @Override
    public ProductDto findById(Long id) {
        Product p=productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource_Not_Found"));
        return  modelMapper.map(p,ProductDto.class);
    }




}
