package com.bolkar.bolkar.controller;

import com.bolkar.bolkar.model.Scheme;
import com.bolkar.bolkar.service.EligibilityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SchemeController {

    private final EligibilityService eligibilityService;

    public SchemeController(EligibilityService eligibilityService) {
        this.eligibilityService = eligibilityService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "BolKar is alive! 🚀";
    }

    @GetMapping("/schemes/eligible")
    public List<Scheme> getEligibleSchemes(
            @RequestParam double age,
            @RequestParam double income,
            @RequestParam String occupation,
            @RequestParam String state) {

        return eligibilityService.getEligibleSchemes(age, income, occupation, state);
    }
}