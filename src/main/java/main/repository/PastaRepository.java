package main.repository;

import main.entity.BurgerEntity;
import main.entity.FriesEntity;
import main.entity.PastaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface PastaRepository extends JpaRepository<PastaEntity, Long> {
    Optional<PastaEntity> findByTitle(String title);
}
