package com.bolkar.bolkar;

import com.bolkar.bolkar.model.Scheme;
import com.bolkar.bolkar.repository.SchemeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final SchemeRepository schemeRepository;

    public DataSeeder(SchemeRepository schemeRepository) {
        this.schemeRepository = schemeRepository;
    }

    @Override
    public void run(String... args) {
        if (schemeRepository.count() > 0) return; // don't seed twice

        schemeRepository.save(new Scheme(null, "PM Kisan Samman Nidhi",
                "Rs 6000 per year for small and marginal farmers",
                "Agriculture", 18.0, 100.0, 2.0, "farmer", "all",
                "https://pmkisan.gov.in"));

        schemeRepository.save(new Scheme(null, "Ayushman Bharat",
                "Free health insurance up to Rs 5 lakh per year",
                "Health", 0.0, 100.0, 5.0, "any", "all",
                "https://pmjay.gov.in"));

        schemeRepository.save(new Scheme(null, "PM Awas Yojana",
                "Affordable housing for low income families",
                "Housing", 18.0, 100.0, 3.0, "any", "all",
                "https://pmaymis.gov.in"));

        schemeRepository.save(new Scheme(null, "Kisan Credit Card",
                "Easy credit for farmers at low interest rates",
                "Agriculture", 18.0, 75.0, 3.0, "farmer", "all",
                "https://www.india.gov.in/kisan-credit-card"));

        schemeRepository.save(new Scheme(null, "PM Scholarship Scheme",
                "Scholarship for students of ex-servicemen",
                "Education", 17.0, 25.0, 6.0, "student", "all",
                "https://scholarships.gov.in"));

        schemeRepository.save(new Scheme(null, "Ujjwala Yojana",
                "Free LPG connection for women below poverty line",
                "Women", 18.0, 100.0, 1.5, "any", "all",
                "https://pmuy.gov.in"));

        schemeRepository.save(new Scheme(null, "Mudra Loan Yojana",
                "Loans up to Rs 10 lakh for small business owners",
                "Business", 18.0, 65.0, 10.0, "business", "all",
                "https://mudra.org.in"));

        System.out.println("✅ Schemes seeded successfully!");
    }
}