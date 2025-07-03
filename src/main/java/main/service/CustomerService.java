package main.service;

import main.dto.CustomerDTO;
import main.entity.CustomerEntity;
import main.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository ;

    ModelMapper modelMapper = new ModelMapper();



    public List<CustomerDTO> getAllCustomers(CustomerDTO customerDTO) {
        List<CustomerEntity> all = customerRepository.findAll();
        List<CustomerDTO>customerDTOS =new ArrayList<>();
        for (CustomerEntity customerEntity : all) {
            CustomerDTO map = modelMapper.map(customerEntity, CustomerDTO.class);
            customerDTOS.add(map);
        }
        return customerDTOS;
    }


    public void addCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = modelMapper.map(customerDTO, CustomerEntity.class);
        customerRepository.save(customerEntity);
    }

    public List<CustomerDTO> searchCustomer(String name) {
        Optional<CustomerEntity> customerEntities = customerRepository.findById(Long.valueOf(name));
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        if (customerEntities.isPresent()) {
            CustomerEntity customerEntity = customerEntities.get();
            CustomerDTO map = modelMapper.map(customerEntity, CustomerDTO.class);
            customerDTOS.add(map);
        } else {
            throw new RuntimeException("Customer with name " + name + " does not exist.");
        }
        return customerDTOS;
    }

    public void deleteCustomer(String name) {
        if (customerRepository.existsById(Long.valueOf(name))) {
            customerRepository.deleteById(Long.valueOf(name));
        } else {
            throw new RuntimeException("Customer with name " + name + " does not exist.");
        }
    }
}
