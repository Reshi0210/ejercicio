package rafael.ejercicio.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
@Data
@NoArgsConstructor
public class Sale {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long idSale;

        private LocalDate date;

        @JsonManagedReference
        @ManyToOne()
        @JoinColumn(name="id_client")
        private Client client;


        @OneToMany(mappedBy ="sale",cascade = CascadeType.ALL)
        private Set<SaleDetail> saleDetail;





}
