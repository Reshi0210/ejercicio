package rafael.ejercicio.Services;

import rafael.ejercicio.DTOs.ProductDto;
import rafael.ejercicio.DTOs.SaleDto;

import java.util.List;

public interface SaleService {

    public List<SaleDto> getAll();

    public SaleDto create(Long idClient, List<ProductDto> productList);
}
