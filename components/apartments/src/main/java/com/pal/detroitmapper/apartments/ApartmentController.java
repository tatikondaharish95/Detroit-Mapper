package com.pal.detroitmapper.apartments;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apartments")
public class ApartmentController {
    private ApartmentRepository repository;

    public ApartmentController(ApartmentRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void addApartment(@RequestBody Apartment apartment) {
        this.repository.addApartment(apartment);
    }

    @DeleteMapping("/{apartmentId}")
    public void deleteApartment(@PathVariable Long apartmentId) {
        this.repository.deleteApartmentId(apartmentId);
    }

    @GetMapping
    public List<Apartment> find(@RequestParam(name = "field", required = false) String field,
                                 @RequestParam(name = "key", required = false) String key,
                                 @RequestParam(name = "start", required = false) Integer start,
                                 @RequestParam(name = "pageSize", required = false) Integer pageSize) {
        if (field != null && key != null) {
            return repository.findRange(field, key, start, pageSize);
        } else if (start != null && pageSize != null) {
            return repository.findAll(start, pageSize);
        }
        return repository.getApartments();
    }

    @GetMapping("/count")
    public int count(@RequestParam(name = "field", required = false) String field,
                     @RequestParam(name = "key", required = false) String key) {
        if (field != null && key != null) {
            return repository.count(field, key);
        }
        return repository.countAll();
    }
}
