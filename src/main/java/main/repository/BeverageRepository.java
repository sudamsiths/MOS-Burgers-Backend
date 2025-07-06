package main.repository;

import main.dto.BeverageDTO;
import main.entity.BeverageEntity;
import main.entity.BurgerEntity;
import main.entity.FriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BeverageRepository extends JpaRepository<BeverageEntity, Long> {
    Optional<BeverageEntity> findByTitle(String title);
}
