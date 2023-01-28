package rafael.ejercicio.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rafael.ejercicio.Models.Product;
import rafael.ejercicio.Services.ProductService;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("app/v1/products")
@AllArgsConstructor
public class ProductController {

    ProductService productService;

    @GetMapping("getAll")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @PostMapping("create")
    public ResponseEntity<Product> create(@RequestBody Product product){
        productService.create(product);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @PutMapping("update/{idOldProduct}")
    public ResponseEntity<Product> update(@PathVariable Long idOldProduct,@RequestBody Product product){
        productService.update(idOldProduct, product);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String,Boolean>> delete(@PathVariable Long id){
        Map<String,Boolean> response=productService.delete(id);
        return new ResponseEntity(response,HttpStatus.OK);
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return new ResponseEntity(productService.findById(id),HttpStatus.OK);
    }

}
