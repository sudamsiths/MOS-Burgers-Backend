package main.repository;

import main.entity.BurgerEntity;
import main.entity.FriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public interface FriesRepository extends JpaRepository<FriesEntity, Long> {
}
