package main.repository;

import main.entity.SubmarinesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public interface SubmarinesRepository extends JpaRepository<SubmarinesEntity, Long> {
}
