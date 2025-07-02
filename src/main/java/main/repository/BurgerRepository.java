package main.repository;

import main.entity.BurgerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public interface BurgerRepository extends JpaRepository<BurgerEntity, Long> {
}
