package com.pal.detroitmapper.apartments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apartments")
public class ApartmentController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ApartmentRepository apartmentRepository;

    public ApartmentController(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    @PostMapping
    public void addApartment(@RequestBody Apartment apartment) {
        apartmentRepository.addApartment(apartment);
    }
    @GetMapping
    public List<Apartment> index() {
        return apartmentRepository.getApartments();
    }

    @GetMapping("/{apartmentId}")
    public Apartment details(@PathVariable long albumId) {
        return apartmentRepository.find(albumId);
    }


    @GetMapping("/{apartmentName}")
    public List<Apartment> details(@PathVariable String apartmentName) {
        return apartmentRepository.find(apartmentName);
    }


}
