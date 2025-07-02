package main.repository;

import main.dto.BeverageDTO;
import main.entity.BeverageEntity;
import main.entity.BurgerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BeverageRepository extends JpaRepository<BeverageEntity, Long> {
}
