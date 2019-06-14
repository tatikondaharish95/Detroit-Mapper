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
    public void addAppartment(@RequestBody Apartment apartment) {
        apartmentRepository.addAppartment(apartment);
    }
    @GetMapping
    public List<Apartment> index() {
        return apartmentRepository.getAppartments();
    }

    @GetMapping("/{apartmentId}")
    public Apartment details(@PathVariable long albumId) {
        return apartmentRepository.find(albumId);
    }


    @GetMapping("/{apartmentName}")
    public List<Apartment> details(@PathVariable String appartmentName) {
        return apartmentRepository.find(appartmentName);
    }


}
