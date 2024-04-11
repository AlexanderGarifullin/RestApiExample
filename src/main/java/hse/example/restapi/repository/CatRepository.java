package hse.example.restapi.repository;

import hse.example.restapi.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat,Integer> {
}
