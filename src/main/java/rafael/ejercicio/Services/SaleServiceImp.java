package rafael.ejercicio.Services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import rafael.ejercicio.DTOs.ProductDto;
import rafael.ejercicio.DTOs.SaleDto;
import rafael.ejercicio.Exeptions.ResourceNotFoundException;
import rafael.ejercicio.Models.Client;
import rafael.ejercicio.Models.Product;
import rafael.ejercicio.Models.Sale;
import rafael.ejercicio.Models.SaleDetail;
import rafael.ejercicio.Repositories.ClientRepository;
import rafael.ejercicio.Repositories.SaleDetailRepository;
import rafael.ejercicio.Repositories.SaleRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class SaleServiceImp implements SaleService {

    ModelMapper modelMapper;
    ClientRepository clientRepository;
    SaleRepository saleRepository;
    SaleDetailRepository saleDetailRepository;

    @Override
    public List<SaleDto> getAll() {
        return saleRepository.findAll().stream().map(sale ->
        {return modelMapper.map(sale,SaleDto.class);})
                .collect(Collectors.toList());
    }

    @Override
    public SaleDto create(Long idClient, List<ProductDto> productList) {
        Sale sale=new Sale();
        sale.setDate(LocalDate.now());
        Client client=clientRepository.findById(idClient).
                orElseThrow(()->new ResourceNotFoundException("RESOURCE_NOT_FOUND"));
        sale.setClient(client);
        saleRepository.save(sale);

        productList.forEach(productDto -> {
            SaleDetail saleDetail=new SaleDetail();
            saleDetail.setProduct(modelMapper.map(productDto,Product.class));
            saleDetail.setSale(sale);
            saleDetailRepository.save(saleDetail);

        });

        return modelMapper.map(sale,SaleDto.class);
    }
}
