package rafael.ejercicio.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table
@Data
@NoArgsConstructor
public class SaleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSaleDetail;


    @ManyToOne
    @JoinColumn(name="id_sale")
    private Sale sale;


    @ManyToOne
    @JoinColumn(name="id_product")
    private Product product;



}
