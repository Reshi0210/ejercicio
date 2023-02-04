package rafael.ejercicio.DTOs;

import lombok.Data;
import rafael.ejercicio.Models.Client;
import rafael.ejercicio.Models.SaleDetail;


import java.time.LocalDate;
import java.util.Set;

@Data
public class SaleDto {


    private long idSale;
    private LocalDate date;
    private Client client;
    //private Set<SaleDetail> saleDetail;
}
