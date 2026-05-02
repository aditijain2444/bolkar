package com.bolkar.bolkar.repository;

import com.bolkar.bolkar.model.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchemeRepository extends JpaRepository<Scheme, Long> {

    List<Scheme> findByOccupationIgnoreCase(String occupation);
    List<Scheme> findByStateIgnoreCaseOrState(String state, String all);
}