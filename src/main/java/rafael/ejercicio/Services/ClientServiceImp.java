package rafael.ejercicio.Services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import rafael.ejercicio.DTOs.ClientDto;
import rafael.ejercicio.Exeptions.ResourceNotFoundException;
import rafael.ejercicio.Models.Client;
import rafael.ejercicio.Repositories.ClientRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImp implements ClientService{

    ModelMapper modelMapper;
    ClientRepository clientRepository;

    @Override
    public List<ClientDto> getAll() {
        return clientRepository.findAll().stream().map(client->
                {return modelMapper.map(client, ClientDto.class);})
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto create(ClientDto client) {
        clientRepository.save(modelMapper.map(client,Client.class));
        return client;
    }

    @Override
    public ClientDto update(Long oldClientId, ClientDto newClient) {
        Client oldClient=clientRepository.findById(oldClientId)
                .orElseThrow(()->new ResourceNotFoundException("RESOURCE_NOT_FOUND"));
        newClient.setIdClient(oldClient.getIdClient());
        clientRepository.save(modelMapper.map(newClient,Client.class));

        return newClient;
    }

    @Override
    public Map<String,Boolean> delete(Long id) {
        Map<String,Boolean>response= new HashMap<>();
        Client client=clientRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("RESOURCE_NOT_FOUND"));
        clientRepository.delete(client);
        response.put("deleted",Boolean.TRUE);

        return response;
    }

    @Override
    public ClientDto findById(Long id) {
        Client client=clientRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("RESOURCE_NOT_FOUND"));
        return modelMapper.map(client,ClientDto.class);
    }
}
