package main.repository;

import main.entity.BurgerEntity;
import main.entity.ChickenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ChickenRepository extends JpaRepository<ChickenEntity, Long> {
}
