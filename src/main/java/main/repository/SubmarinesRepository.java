package main.repository;

import main.entity.FriesEntity;
import main.entity.SubmarinesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface SubmarinesRepository extends JpaRepository<SubmarinesEntity, Long> {
    Optional<SubmarinesEntity> findByTitle(String title);
}
