package rafael.ejercicio.DTOs;

import lombok.Data;
import rafael.ejercicio.Models.SaleDetail;

import java.util.Set;

@Data
public class ProductDto {

    private long idProduct;
    private String name;
    private Double price;
    // private Set<SaleDetail> SaleDetails;
}
