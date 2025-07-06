package main.repository;

import main.entity.BurgerEntity;
import main.entity.ChickenEntity;
import main.entity.FriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ChickenRepository extends JpaRepository<ChickenEntity, Long> {
    Optional<ChickenEntity> findByTitle(String title);
}
