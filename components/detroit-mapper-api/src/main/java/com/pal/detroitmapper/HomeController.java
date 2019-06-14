package com.pal.detroitmapper;

import com.pal.detroitmapper.appartmentsapi.AppartmentFixtures;
import com.pal.detroitmapper.appartmentsapi.AppartmentInfo;
import com.pal.detroitmapper.appartmentsapi.AppartmentsClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class HomeController {

    private final AppartmentsClient appartmentsClient;
    private final AppartmentFixtures appartmentFixtures;

    public HomeController(AppartmentsClient appartmentsClient, AppartmentFixtures appartmentFixtures) {
        this.appartmentsClient = appartmentsClient;
        this.appartmentFixtures = appartmentFixtures;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/setup")
    public String setup(Map<String, Object> model) {
        for (AppartmentInfo info: appartmentFixtures.load()) {
            appartmentsClient.addApartment(info);
        }
        model.put("restaurants", appartmentsClient.getAppartments());

        return "setup";
    }
}
