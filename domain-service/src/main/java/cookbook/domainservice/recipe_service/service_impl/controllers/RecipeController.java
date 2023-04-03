package cookbook.domainservice.recipe_service.service_impl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cookbook.domainservice.recipe_service.service_impl.entities.Measurement;
import cookbook.domainservice.recipe_service.service_impl.repositories.MeasurementRepository;

@Controller
@RequestMapping(path="/demo")
public class RecipeController {
    @Autowired
    private MeasurementRepository measurementRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Measurement> getAllMeasurements() {
        return measurementRepository.findAll();
    }
}