package rafael.ejercicio.Services;

import rafael.ejercicio.DTOs.ClientDto;


import java.util.List;
import java.util.Map;

public interface ClientService {

    public List<ClientDto> getAll();

    public ClientDto create(ClientDto client);

    public ClientDto update(Long id, ClientDto client);

    public Map<String,Boolean> delete(Long id);

    public ClientDto findById(Long id);


}
