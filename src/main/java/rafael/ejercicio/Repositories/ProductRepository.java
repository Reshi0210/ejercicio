package rafael.ejercicio.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rafael.ejercicio.Models.Product;


public interface ProductRepository extends JpaRepository<Product,Long> {
}
