package rafael.ejercicio.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rafael.ejercicio.DTOs.ClientDto;
import rafael.ejercicio.Services.ClientService;


import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("app/v1/clients")
public class ClientController {

    ClientService clientService;

    @GetMapping("getAll")
    public List<ClientDto> getAll() {
        return clientService.getAll();
    }

    @PostMapping("create")
    public ResponseEntity<ClientDto> create(@RequestBody ClientDto c){
        clientService.create(c);
        return new ResponseEntity(c, HttpStatus.OK);
    }

    @PutMapping("update/{idOldClient}")
    public ResponseEntity<ClientDto> update(@PathVariable Long idOldClient, @RequestBody ClientDto client){
        clientService.update(idOldClient, client);
        return new ResponseEntity(client, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String,Boolean>> delete(@PathVariable Long id){
        Map<String,Boolean> response=clientService.delete(id);
        return new ResponseEntity(response,HttpStatus.OK);
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable Long id){
        return new ResponseEntity(clientService.findById(id),HttpStatus.OK);
    }


}