package rafael.ejercicio.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Data
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClient;

    private String name;

    private String lastName;

    @Column(unique = true)
    private String dni;

    private String phone;

    private String email;

    @JsonBackReference
    @OneToMany(mappedBy ="client",cascade = CascadeType.ALL)
    private Set<Sale> sales;


}
