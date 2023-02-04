package rafael.ejercicio.Wrappers;

import lombok.Data;
import rafael.ejercicio.DTOs.ProductDto;
import rafael.ejercicio.Models.SaleDetail;

import java.util.List;

@Data
public class SaleW {

    long id;
    List<ProductDto> productList;
}
