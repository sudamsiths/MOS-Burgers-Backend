package main.repository;

import main.entity.BurgerEntity;
import main.entity.FriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface BurgerRepository extends JpaRepository<BurgerEntity, Long> {
    Optional<BurgerEntity> findByTitle(String title);
}
