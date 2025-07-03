package main.controller;

import main.dto.CustomerDTO;
import main.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService  customerService ;

    @GetMapping("/getAll")
    public List<CustomerDTO>getAllCustomers(CustomerDTO customerDTO) {
        return customerService.getAllCustomers(customerDTO);
    }

    @PostMapping("/add")
    public void addCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.addCustomer(customerDTO);
    }
    @GetMapping("/search/{name}")
    public List<CustomerDTO> searchCustomer(@PathVariable String name) {
        return customerService.searchCustomer(name);
    }
    @DeleteMapping("/delete/{name}")
    public void deleteCustomer(@PathVariable String name) {
        customerService.deleteCustomer(name);
    }
}
