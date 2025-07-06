package main.repository;

import main.entity.BurgerEntity;
import main.entity.FriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface FriesRepository extends JpaRepository<FriesEntity, Long> {
    Optional<FriesEntity> findByTitle(String title);

}
