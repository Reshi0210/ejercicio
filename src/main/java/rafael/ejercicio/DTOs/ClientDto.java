package rafael.ejercicio.DTOs;

import lombok.Data;
import rafael.ejercicio.Models.Sale;

import java.util.Set;

@Data
public class ClientDto {

    private long idClient;
    private String name;
    private String lastName;
    private String dni;
    private String phone;
    private String email;
    //private Set<Sale> sales;

}
