package rafael.ejercicio.Controllers;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rafael.ejercicio.DTOs.ProductDto;
import rafael.ejercicio.Services.ProductService;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("app/v1/products")
@AllArgsConstructor
public class ProductController {

    ProductService productService;

    @GetMapping("getAll")
    public List<ProductDto> getAll(){
        return productService.getAll();
    }

    @PostMapping("create")
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto p){
        productService.create(p);
        return new ResponseEntity(p, HttpStatus.OK);
    }

    @PutMapping("update/{idOldProduct}")
    public ResponseEntity<ProductDto> update(@PathVariable Long idOldProduct,@RequestBody ProductDto product){
        productService.update(idOldProduct, product);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String,Boolean>> delete(@PathVariable Long id){
        Map<String,Boolean> response=productService.delete(id);
        return new ResponseEntity(response,HttpStatus.OK);
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable Long id){
        return new ResponseEntity(productService.findById(id),HttpStatus.OK);
    }



}
