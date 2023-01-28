package rafael.ejercicio.Models;

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

        @ManyToOne(fetch =FetchType.LAZY)
        @JoinColumn(name="id_client")
        private Client client;

        @OneToMany(mappedBy ="sale",cascade = CascadeType.ALL)
        private Set<SaleDetail> saleDetail;





}
