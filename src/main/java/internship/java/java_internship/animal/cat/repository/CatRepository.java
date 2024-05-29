package internship.java.java_internship.animal.cat.repository;

import internship.java.java_internship.animal.cat.model.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CatRepository extends JpaRepository<Cat, UUID> {
}
