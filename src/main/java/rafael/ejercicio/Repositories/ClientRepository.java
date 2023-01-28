package rafael.ejercicio.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rafael.ejercicio.Models.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
