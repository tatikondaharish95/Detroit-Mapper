package com.pal.detroitmapper.appartments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appartments")
public class AppartmentController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final AppartmentRepository appartmentRepository;

    public AppartmentController(AppartmentRepository appartmentRepository) {
        this.appartmentRepository = appartmentRepository;
    }

    @PostMapping
    public void addAppartment(@RequestBody Appartment appartment) {
        appartmentRepository.addAppartment(appartment);
    }
    @GetMapping
    public List<Appartment> index() {
        return appartmentRepository.getAppartments();
    }

    @GetMapping("/{apartmentId}")
    public Appartment details(@PathVariable long albumId) {
        return appartmentRepository.find(albumId);
    }


    @GetMapping("/{apartmentName}")
    public List<Appartment> details(@PathVariable String appartmentName) {
        return appartmentRepository.find(appartmentName);
    }


}
