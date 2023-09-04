package com.prodapt.cycle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodapt.cycle.Cycle;

public interface CycleRepository extends JpaRepository<Cycle, Integer> {
}
