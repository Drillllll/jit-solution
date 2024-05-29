package internship.java.java_internship.animal.cat.controller;

import internship.java.java_internship.animal.cat.model.entity.Cat;
import internship.java.java_internship.animal.cat.service.CatService;
import internship.java.java_internship.animal.cat.service.CatServiceJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;


//@RequiredArgsConstructor
@RestController
public class AnimalController {
    public static final String CAT_PATH = "/app/v1/cat";
    public static final String CAT_PATH_ID= CAT_PATH + "/{catId}";
    private final CatService catService;

    public AnimalController(CatService catService) {
        this.catService = catService;
    }


    @GetMapping(CAT_PATH_ID)
    public ResponseEntity<Cat> getCat(@PathVariable("catId") UUID catId) {
        return ResponseEntity.ok(catService.getCatById(catId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @PostMapping(CAT_PATH)
    public ResponseEntity<Cat> postCat(@RequestBody Cat cat) {
        Cat savedCat =  catService.saveNewCat(cat);
        HttpHeaders headers = new HttpHeaders();
        //headers.add("Location", CAT_PATH + "/" + savedCat.getId().toString());

        //return new ResponseEntity<>(savedCat, headers, HttpStatus.CREATED);
        return new ResponseEntity<>(savedCat, HttpStatus.CREATED);
    }
}
