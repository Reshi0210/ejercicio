package rafael.ejercicio.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rafael.ejercicio.DTOs.ProductDto;
import rafael.ejercicio.DTOs.SaleDto;
import rafael.ejercicio.Services.SaleService;
import rafael.ejercicio.Wrappers.SaleW;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("app/v1/sales")
public class SaleController {

    SaleService saleService;

    @GetMapping("getAll")
    public List<SaleDto> getAll(){
        return saleService.getAll();
    }

    @PostMapping("create")
    public ResponseEntity<ProductDto> create(@RequestBody SaleW s){
        saleService.create(s.getId(),s.getProductList());
        return new ResponseEntity(s, HttpStatus.OK);
    }

}
