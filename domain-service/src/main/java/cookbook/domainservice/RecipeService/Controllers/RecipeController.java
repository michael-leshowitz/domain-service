package cookbook.domainservice.RecipeService.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cookbook.domainservice.RecipeService.Entities.Measurement;
import cookbook.domainservice.RecipeService.Repositories.MeasurementRepository;

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
