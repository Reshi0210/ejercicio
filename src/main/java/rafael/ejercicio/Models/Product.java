package rafael.ejercicio.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduct;

    private String name;

    private Double price;

    @OneToMany(mappedBy ="product")
    private Set<SaleDetail> SaleDetails;

}
