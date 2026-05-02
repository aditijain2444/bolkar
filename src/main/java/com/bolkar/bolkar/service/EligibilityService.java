package com.bolkar.bolkar.service;

import com.bolkar.bolkar.model.Scheme;
import com.bolkar.bolkar.repository.SchemeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EligibilityService {

    private final SchemeRepository schemeRepository;

    public EligibilityService(SchemeRepository schemeRepository) {
        this.schemeRepository = schemeRepository;
    }

    public List<Scheme> getEligibleSchemes(double age, double income, String occupation, String state) {

        List<Scheme> allSchemes = schemeRepository.findAll();
        List<Scheme> eligible = new ArrayList<>();

        for (Scheme scheme : allSchemes) {
            boolean ageMatch = age >= scheme.getMinAge() && age <= scheme.getMaxAge();
            boolean incomeMatch = income <= scheme.getMaxIncome();
            boolean occupationMatch = scheme.getOccupation().equalsIgnoreCase("any")
                    || scheme.getOccupation().equalsIgnoreCase(occupation);
            boolean stateMatch = scheme.getState().equalsIgnoreCase("all")
                    || scheme.getState().equalsIgnoreCase(state);

            if (ageMatch && incomeMatch && occupationMatch && stateMatch) {
                eligible.add(scheme);
            }
        }

        return eligible;
    }
}