package main.repository;

import main.entity.CustomerEntity;
import main.entity.FriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity , Long> {
    Optional<CustomerEntity> findByphoneNumber(String phoneNumber);
}
