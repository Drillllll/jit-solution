package internship.java.java_internship.animal.cat.service;

import internship.java.java_internship.animal.cat.model.entity.Cat;
import internship.java.java_internship.animal.cat.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;
import java.util.UUID;

@Service
@Primary
@Validated
public class CatServiceJPA implements CatService{

    private final CatRepository catRepository;

    public CatServiceJPA(CatRepository catRepository) {
        this.catRepository = catRepository;
    }
    @Override
    public Optional<Cat> getCatById(UUID catId) {
        return Optional.ofNullable(catRepository.findById(catId)
                .orElse(null));
    }

    @Override
    public Cat saveNewCat(Cat cat) {
        return catRepository.save(cat);
    }


}
