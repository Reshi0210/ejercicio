package rafael.ejercicio.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rafael.ejercicio.Models.Sale;

public interface SaleRepository extends JpaRepository<Sale,Long> {
}
