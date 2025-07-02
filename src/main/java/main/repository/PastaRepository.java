package main.repository;

import main.entity.BurgerEntity;
import main.entity.PastaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public interface PastaRepository extends JpaRepository<PastaEntity, Long> {
}
