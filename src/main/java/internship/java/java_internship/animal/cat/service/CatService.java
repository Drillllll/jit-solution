package internship.java.java_internship.animal.cat.service;


import internship.java.java_internship.animal.cat.model.entity.Cat;

import java.util.Optional;
import java.util.UUID;

public interface CatService {
    Optional<Cat> getCatById(UUID catId);
    Cat saveNewCat(Cat cat);
}
